import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {TaskList} from './task-list/task-list';
import {TaskForm} from './task-form/task-form';
import {TaskItem} from './task-item/task-item';
import {Task} from './models/Task';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TaskList, TaskForm, TaskItem],
  templateUrl: './app.html',
  standalone: true,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontAngularVinte');
  tasks: Task[] = [];

  addTask(task: any) {
    this.tasks.push(task);
  }

  deleteTask(taskId: number) {
    this.tasks = this.tasks.filter(task => task.id !== taskId);
  }
}
