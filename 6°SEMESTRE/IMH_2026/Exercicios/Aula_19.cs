# ---------- Build ----------
FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src

# Copia csproj e restaura dependências
COPY Api/*.csproj Api/
RUN dotnet restore Api/Api.csproj

# Copia o restante e publica
COPY . .
WORKDIR /src/Api
RUN dotnet publish -c Release -o /app/publish

# ---------- Runtime ----------
FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS runtime
WORKDIR /app
EXPOSE 8080

# Copia artefatos publicados
COPY --from=build /app/publish .

# Variáveis de ambiente
ENV ASPNETCORE_URLS=http://+:8080
ENTRYPOINT ["dotnet", "Api.dll"]

_

# ---------- Build ----------
FROM node:20-alpine AS build
WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

# ---------- Runtime ----------
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

_

version: "3.9"

services:
  api:
    build:
      context: .
      dockerfile: src/Api/Dockerfile
    image: aula19/api:1.0.0
    ports:
      - "5001:8080"
    environment:
      - ASPNETCORE_ENVIRONMENT=Production
    networks:
      - app-net

  frontend:
    build:
      context: ./frontend
      dockerfile: Dockerfile
    image: aula19/frontend:1.0.0
    ports:
      - "5173:80"
    depends_on:
      - api
    networks:
      - app-net

networks:
  app-net:
    driver: bridge

_

docker compose build
docker compose up

_

docker compose down

_

MAJOR.MINOR.PATCH

_

image: aula19/api:1.1.0

_

name: CI - Build Docker Images

on:
  push:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v4

      - name: Build API
        run: docker build -t aula19/api:latest -f src/Api/Dockerfile .

      - name: Build Frontend
        run: docker build -t aula19/frontend:latest ./frontend

_

