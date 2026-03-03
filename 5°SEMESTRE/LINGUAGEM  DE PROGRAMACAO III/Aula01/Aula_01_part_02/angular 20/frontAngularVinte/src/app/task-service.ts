import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Task } from "./models/Task";

@Injectable({ providedIn: 'root' })  // Disponibiliza o serviço em toda a aplicação
export class TaskService {
  private apiUrl = 'http://localhost:8080/api/tasks';  // URL da API

  constructor(private http: HttpClient) {}  // Injeção do HttpClient

  // Método para obter todas as tarefas
  getTasks() {
    return this.http.get<Task[]>(this.apiUrl);  // Retorna um Observable de Task[]
  }

  // Método para adicionar uma nova tarefa
  addTask(task: { title: string; completed: boolean }) {
    return this.http.post<Task>(this.apiUrl, task);  // Envia a tarefa para a API
  }

  deleteTask(id: number) {
    return this.http.delete(`${this.apiUrl}/${id}`); // Faz requisição DELETE
  }
}
