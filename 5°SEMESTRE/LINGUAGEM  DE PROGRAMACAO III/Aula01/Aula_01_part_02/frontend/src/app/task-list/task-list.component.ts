import { Component, OnInit } from '@angular/core';
import { Task } from '../Task';
import { TaskService } from '../task.service';

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

    

