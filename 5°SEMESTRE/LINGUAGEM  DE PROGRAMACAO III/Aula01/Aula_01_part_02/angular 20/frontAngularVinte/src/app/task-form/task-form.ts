import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Task } from "../models/Task";
import {FormsModule} from '@angular/forms';



@Component({
  selector: 'app-task-form',
  imports: [FormsModule],
  templateUrl: './task-form.html',
  styleUrl: './task-form.css',
  standalone: true,
})
export class TaskForm{

  @Output() add = new EventEmitter<Task>();  // Emite nova tarefa para o componente pai

  newTask: Task = { id: Date.now(), title: '', completed: false }; // Modelo para nova tarefa


  // Método chamado ao submeter o formulário
  onSubmit() {
    this.add.emit(this.newTask); // Emite a nova tarefa
    this.newTask = { id: Date.now(), title: '', completed: false }; // Reseta o formulário
  }


}
