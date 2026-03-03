import {Component, EventEmitter, Input, Output} from '@angular/core';
import { Task } from "../models/Task";

@Component({
  selector: 'app-task-item',
  imports: [],
  templateUrl: './task-item.html',
  styleUrl: './task-item.css'
})
export class TaskItem {
  @Input() task!: Task;              // Recebe a tarefa do componente pai (decorador @Input)
  @Output() delete = new EventEmitter<number>();  // Emite evento de exclusão para o pai (decorador @Output)

  // Método chamado quando o botão de excluir é clicado
  onDelete() {
    this.delete.emit(this.task.id); // Emite o ID da tarefa a ser excluída
  }
}
