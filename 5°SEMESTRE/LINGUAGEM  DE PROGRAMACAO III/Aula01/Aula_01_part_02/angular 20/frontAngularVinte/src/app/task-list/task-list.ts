import { Component, OnInit } from '@angular/core';
import { Task } from "../models/Task";
import {TaskService} from '../task-service';
import { FormsModule } from "@angular/forms";

@Component({
  selector: 'app-task-list',
  imports: [FormsModule],
  templateUrl: './task-list.html',
  standalone: true,
  styleUrl: './task-list.css'
})
export class TaskList implements OnInit {
  tasks: Task[] = [];  // Lista de tarefas
  newTask: { title: string; completed: boolean } = { title: '', completed: false };  // Modelo para nova tarefa

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

  // Método no componente pai para deletar tarefa (com chamada HTTP)
  deleteTask(taskId: number) {
    this.taskService.deleteTask(taskId).subscribe(() => {
      this.loadTasks(); // Recarrega a lista após exclusão
    });
  }
}
