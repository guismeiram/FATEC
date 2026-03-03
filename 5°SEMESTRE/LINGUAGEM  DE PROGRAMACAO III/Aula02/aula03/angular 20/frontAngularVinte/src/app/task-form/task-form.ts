import {Component, EventEmitter, Output} from '@angular/core';
import { Task } from "../models/Task";

@Component({
  selector: 'app-task-form',
  imports: [],
  templateUrl: './task-form.html',
  styleUrl: './task-form.css'
})
export class TaskForm {
  @Output() add = new EventEmitter<Task>();  // Emite nova tarefa para o componente pai
  newTask: Task = { id: Date.now(),title: '', completed: false }; // Modelo para nova tarefa

  // Método chamado ao submeter o formulário
  onSubmit() {
    this.add.emit(this.newTask); // Emite a nova tarefa
    this.newTask = { id: Date.now(),title: '', completed: false }; // Reseta o formulário
  }
}
