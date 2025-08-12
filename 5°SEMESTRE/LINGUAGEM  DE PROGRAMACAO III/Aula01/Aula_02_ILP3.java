# Configuração da conexão com o banco de dados MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db  # URL de conexão JDBC
spring.datasource.username=root  # Usuário do banco de dados
spring.datasource.password=senha  # Senha do banco de dados (em produção, use variáveis de ambiente)

# Configuração do Hibernate (JPA)
spring.jpa.hibernate.ddl-auto=update  # Atualiza o esquema do banco automaticamente (cuidado em produção)
________________________________________________________________

import javax.persistence.*;

// @Entity indica que esta classe é uma entidade persistente
@Entity
public class Task {
    
    // @Id marca o campo como chave primária
    // @GeneratedValue define a estratégia de auto-incremento
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;       // Título da tarefa
    private boolean completed; // Status de conclusão
    
    // Getters e Setters (gerados pelo Lombok ou manualmente)
    // ...
}
________________________________________________________________


import org.springframework.data.jpa.repository.JpaRepository;

// Interface que estende JpaRepository para operações CRUD
// JpaRepository<Task, Long> => Entidade Task, ID do tipo Long
public interface TaskRepository extends JpaRepository<Task, Long> {}
________________________________________________________________

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")  // Mapeia todas as rotas para /api/tasks
public class TaskController {

    @Autowired  // Injeção automática do repositório
    private TaskRepository repository;

    // GET /api/tasks - Retorna todas as tarefas
    @GetMapping
    public List<Task> getAll() {
        return repository.findAll();  // Usa o método padrão do JpaRepository
    }

    // POST /api/tasks - Cria uma nova tarefa
    @PostMapping
    public Task create(@RequestBody Task task) {  // @RequestBody converte o JSON para objeto Task
        return repository.save(task);  // Salva a nova tarefa no banco
    }
}
________________________________________________________________

# Cria um novo serviço Angular chamado 'task'
ng generate service task
________________________________________________________________

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })  // Disponibiliza o serviço em toda a aplicação
export class TaskService {
  private apiUrl = 'http://localhost:8080/api/tasks';  // URL da API

  constructor(private http: HttpClient) {}  // Injeção do HttpClient

  // Método para obter todas as tarefas
  getTasks() {
    return this.http.get<Task[]>(this.apiUrl);  // Retorna um Observable de Task[]
  }

  // Método para adicionar uma nova tarefa
  addTask(task: Task) {
    return this.http.post<Task>(this.apiUrl, task);  // Envia a tarefa para a API
  }
}

________________________________________________________________

# Cria um novo componente Angular chamado 'task-list'
ng generate component task-list
________________________________________________________________

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  tasks: Task[] = [];  // Lista de tarefas
  newTask: Task = { title: '', completed: false };  // Modelo para nova tarefa

  constructor(private taskService: TaskService) {}  // Injeção do TaskService

  // Método chamado quando o componente é inicializado
  ngOnInit() {
    this.loadTasks();
  }

  // Carrega as tarefas do servidor
  loadTasks() {
    this.taskService.getTasks().subscribe(tasks => {
      this.tasks = tasks;  // Atualiza a lista de tarefas
    });
  }

  // Adiciona uma nova tarefa
  addTask() {
    this.taskService.addTask(this.newTask).subscribe(() => {
      this.loadTasks();  // Recarrega a lista após adicionar
      this.newTask = { title: '', completed: false };  // Reseta o formulário
    });
  }
}

________________________________________________________________

<div>
  <!-- Two-way data binding com ngModel -->
  <input [(ngModel)]="newTask.title" placeholder="Nova tarefa">
  
  <!-- Event binding para o click do botão -->
  <button (click)="addTask()">Adicionar</button>
  
  <!-- Lista de tarefas -->
  <ul>
    <!-- *ngFor para iterar sobre a lista de tarefas -->
    <li *ngFor="let task of tasks">
      {{ task.title }} - {{ task.completed ? '✓' : '✗' }}  <!-- Exibe ✓ ou ✗ baseado no status -->
    </li>
  </ul>
</div>

________________________________________________________________

