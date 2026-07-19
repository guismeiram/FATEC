// Importa o módulo ReactiveFormsModule para trabalhar com formulários reativos
import { ReactiveFormsModule } from '@angular/forms';  

// Configuração do módulo principal da aplicação
@NgModule({  
  imports: [ReactiveFormsModule], // Importa o módulo de formulários reativos
})

// Comando Angular CLI para gerar o componente de edição
ng generate component task-edit  

// Configuração da rota para edição de tarefas (usa o mesmo padrão de ID mas com /edit)
{ path: 'tasks/:id/edit', component: TaskEditComponent }  

// Componente de edição de tarefas
export class TaskEditComponent implements OnInit {  
  taskForm: FormGroup;  // Grupo de controles do formulário

  constructor(  
    private fb: FormBuilder,          // Serviço para criação de formulários
    private route: ActivatedRoute,    // Para acessar parâmetros da rota
    private taskService: TaskService  // Serviço para operações com tarefas
  ) {  
    // Cria o formulário com validações
    this.taskForm = this.fb.group({  
      title: ['', [Validators.required, Validators.minLength(3)]], // Campo obrigatório com mínimo 3 chars
      completed: [false]  // Checkbox com valor padrão false
    });  
  }  

  ngOnInit() {  
    // Obtém o ID da tarefa da URL
    const taskId = this.route.snapshot.params['id'];  
    // Carrega a tarefa e preenche o formulário
    this.taskService.getTaskById(taskId).subscribe(task => {  
      this.taskForm.patchValue(task);  // Preenche o form com os valores da tarefa
    });  
  }  

  // Método chamado ao submeter o formulário
  onSubmit() {  
    if (this.taskForm.valid) {  // Só prossegue se o form for válido
      // Cria objeto com valores do form + ID da rota
      const updatedTask = { ...this.taskForm.value, id: this.route.snapshot.params['id'] };  
      // Chama serviço para atualizar e navega para detalhes após sucesso
      this.taskService.updateTask(updatedTask).subscribe(() => {  
        this.router.navigate(['/tasks', updatedTask.id]);  
      });  
    }  
  }  
}  

// Método no serviço para atualizar tarefa (HTTP PUT)
updateTask(task: Task) {  
  return this.http.put(`${this.apiUrl}/${task.id}`, task);  
}  

/* Template do formulário de edição */
<form [formGroup]="taskForm" (ngSubmit)="onSubmit()">  
  <div>  
    <label>Título:</label>  
    <input formControlName="title">  <!-- Vincula ao controle 'title' do form -->
    
    <!-- Mensagens de validação -->
    <div *ngIf="taskForm.get('title')?.errors?.['required'] && taskForm.get('title')?.touched" class="error">  
      Título é obrigatório.  
    </div>  
    <div *ngIf="taskForm.get('title')?.errors?.['minlength']" class="error">  
      Mínimo 3 caracteres.  
    </div>  
  </div>  

  <div>  
    <label>  
      <input type="checkbox" formControlName="completed"> <!-- Checkbox vinculado -->
      Concluída  
    </label>  
  </div>  

  <!-- Botões de ação -->
  <button type="submit" [disabled]="!taskForm.valid">Salvar</button>  <!-- Só habilitado se válido -->
  <button type="button" routerLink="/tasks/{{route.snapshot.params['id']}}">Cancelar</button>  
</form>  

/* Estilo para mensagens de erro */
.error { color: red; font-size: 12px; }  

// Validador customizado para títulos proibidos
export function forbiddenTitleValidator(titleRe: RegExp) {  
  return (control: AbstractControl) => {  
    const forbidden = titleRe.test(control.value);  // Testa o valor contra regex
    return forbidden ? { forbiddenTitle: { value: control.value } } : null;  // Retorna erro ou null
  };  
}  

/* Fluxo completo do formulário reativo:
1. Preenche campos → 2. Valida → 3. Submete → 4. Atualiza API → 5. Navega para detalhes  
*/