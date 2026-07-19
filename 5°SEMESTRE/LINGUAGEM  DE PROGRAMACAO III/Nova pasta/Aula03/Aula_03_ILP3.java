// Decorador @Component define um componente Angular
@Component({
  selector: 'app-exemplo', // Seletor usado no template HTML
  templateUrl: './exemplo.component.html', // Caminho para o template
  styleUrls: ['./exemplo.component.css'] // Estilos específicos do componente
})
export class ExemploComponent {
  // O construtor com injeção de dependência
  constructor(private service: MeuServico) {}  
  // Angular fornece automaticamente uma instância do MeuServico
}

// Comandos para gerar novos componentes usando Angular CLI
ng generate component task-item      # Cria componente para exibir uma tarefa individual
ng generate component task-form     # Cria componente para o formulário de adição

// Componente para exibir uma tarefa individual
@Component({...})
export class TaskItemComponent {
  @Input() task!: Task;              // Recebe a tarefa do componente pai (decorador @Input)
  @Output() delete = new EventEmitter<number>();  // Emite evento de exclusão para o pai (decorador @Output)

  // Método chamado quando o botão de excluir é clicado
  onDelete() {
    this.delete.emit(this.task.id); // Emite o ID da tarefa a ser excluída
  }
}

/* Template HTML para o TaskItemComponent - exibe cada tarefa */
<li>
  {{ task.title }} - {{ task.completed ? '✓' : '✗' }} <!-- Exibe título e status -->
  <button (click)="onDelete()">Excluir</button> <!-- Botão que dispara a exclusão -->
</li>

// Componente para o formulário de adição de tarefas
@Component({...})
export class TaskFormComponent {
  @Output() add = new EventEmitter<Task>();  // Emite nova tarefa para o componente pai
  newTask: Task = { title: '', completed: false }; // Modelo para nova tarefa

  // Método chamado ao submeter o formulário
  onSubmit() {
    this.add.emit(this.newTask); // Emite a nova tarefa
    this.newTask = { title: '', completed: false }; // Reseta o formulário
  }
}

/* Template HTML para o TaskFormComponent - formulário de adição */
<input [(ngModel)]="newTask.title" placeholder="Nova tarefa"> <!-- Two-way data binding -->
<button (click)="onSubmit()">Adicionar</button> <!-- Botão para adicionar -->

/* Template HTML do componente pai que usa os componentes filhos */
<app-task-form (add)="addTask($event)"></app-task-form> <!-- Recebe evento add -->
<ul>
  <app-task-item 
    *ngFor="let task of tasks"  // Diretiva *ngFor para repetição
    [task]="task"              // Passa a tarefa para o componente filho
    (delete)="deleteTask($event)"> // Recebe evento delete
  </app-task-item>
</ul>

// Método no componente pai para deletar tarefa (com chamada HTTP)
deleteTask(taskId: number) {
  this.taskService.deleteTask(taskId).subscribe(() => {
    this.loadTasks(); // Recarrega a lista após exclusão
  });
}

// Método no serviço para deletar tarefa no backend
deleteTask(id: number) {
  return this.http.delete(`${this.apiUrl}/${id}`); // Faz requisição DELETE
}

/* Estilos CSS específicos para o componente TaskItem */
/* task-item.component.css */
li { 
  padding: 8px;           /* Espaçamento interno */
  margin: 4px 0;          /* Margem entre itens */
  border: 1px solid #ddd; /* Borda sutil */
}