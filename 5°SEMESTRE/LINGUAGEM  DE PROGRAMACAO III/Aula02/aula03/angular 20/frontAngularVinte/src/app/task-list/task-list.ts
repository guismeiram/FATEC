import { Component, OnInit } from '@angular/core';
import { Task } from "../models/Task";
import {TaskService} from '../task-service';
import { FormsModule } from "@angular/forms";
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-task-list',
  imports: [FormsModule, NgClass],
  templateUrl: './task-list.html',
  standalone: true,
  styleUrl: './task-list.css'
})
export class TaskList implements OnInit {
  isChecked: boolean = false; // Começa desmarcado
  tasks: Task[] = [];  // Lista de tarefas
  newTask: Task = { id: Date.now(),title: '', completed: false };  // Modelo para nova tarefa. Inicialize como false

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
      this.newTask = { id: Date.now(),title: '', completed: false };  // Reseta o formulário
    });
  }

  // Método para lidar com a mudança no checkbox
  onCheckboxChange(event: any) {
    this.newTask.completed = event.target.checked;
  }
}
