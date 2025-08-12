// Configuração das rotas da aplicação
const routes: Routes = [
  { path: 'tasks', component: TaskListComponent }, // Rota para lista de tarefas
  { path: 'tasks/:id', component: TaskDetailComponent }, // Rota para detalhe da tarefa (com parâmetro ID)
  { path: '', redirectTo: '/tasks', pathMatch: 'full' } // Rota vazia redireciona para /tasks
];

// Injeção do serviço Router para navegação programática
constructor(private router: Router) {}  
// Exemplo de navegação para detalhe de tarefa
this.router.navigate(['/tasks', taskId]);  // Navega para /tasks/1 (onde 1 é o ID)

// Import para acessar parâmetros da rota atual
import { ActivatedRoute } from '@angular/router';  
// Como acessar parâmetros da rota (observable)
this.route.params.subscribe(params => console.log(params['id']));

// Configuração completa do módulo de roteamento
import { RouterModule, Routes } from '@angular/router';  
import { TaskListComponent } from './task-list/task-list.component';  
import { TaskDetailComponent } from './task-detail/task-detail.component';  

const routes: Routes = [  
  { path: 'tasks', component: TaskListComponent },  
  { path: 'tasks/:id', component: TaskDetailComponent },  
  { path: '', redirectTo: '/tasks', pathMatch: 'full' } // pathMatch: 'full' para redirecionar exato
];  

@NgModule({  
  imports: [RouterModule.forRoot(routes)], // Configura as rotas principais
  exports: [RouterModule] // Exporta RouterModule para AppModule
})  
export class AppRoutingModule {}  

/* Template principal com navegação e outlet para rotas */
<header>  
  <h1>Gerenciador de Tarefas</h1>  
  <nav>  
    <a routerLink="/tasks">Lista</a> <!-- Link para lista de tarefas --> 
  </nav>  
</header>  
<router-outlet></router-outlet> <!-- Aqui os componentes das rotas serão renderizados -->

// Comando para criar componente de detalhe da tarefa
ng generate component task-detail  

// Componente de detalhe da tarefa
export class TaskDetailComponent implements OnInit {  
  task?: Task; // Tarefa que será carregada

  constructor(  
    private route: ActivatedRoute, // Para acessar parâmetros da rota
    private taskService: TaskService // Serviço para buscar dados
  ) {}  

  ngOnInit() {  
    // snapshot.params pega os parâmetros uma vez (sem observable)
    const taskId = this.route.snapshot.params['id']; 
    // Busca a tarefa pelo ID
    this.taskService.getTaskById(taskId).subscribe(task => this.task = task);  
  }  
}  

// Método no serviço para buscar tarefa por ID
getTaskById(id: number) {  
  return this.http.get<Task>(`${this.apiUrl}/${id}`); // Requisição GET com ID
}  

/* Template do componente de detalhe */
<div *ngIf="task"> <!-- Só exibe se task existir -->
  <h2>{{ task.title }}</h2>  
  <p>Status: {{ task.completed ? 'Concluída' : 'Pendente' }}</p>  
  <button routerLink="/tasks">Voltar</button> <!-- Botão com link para lista -->
</div>  

/* Template da lista de tarefas com links para detalhes */
<ul>  
  <li *ngFor="let task of tasks">  
    <!-- routerLink dinâmico para detalhe da tarefa -->
    <a [routerLink]="['/tasks', task.id]">{{ task.title }}</a> 
    <button (click)="deleteTask(task.id)">Excluir</button>  
  </li>  
</ul>  

/* Estilização dos links */
a {  
  color: #007bff; /* Cor azul padrão para links */
  text-decoration: none; /* Remove sublinhado */
  margin-right: 10px; /* Espaçamento à direita */
}  