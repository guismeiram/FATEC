# Configurações do arquivo application.properties (Spring Boot)
spring.datasource.url=${DB_URL}  # URL do banco de dados (configurada via variável de ambiente)
jwt.secret=${JWT_SECRET}  # Chave secreta para JWT (configurada via variável de ambiente) 

______________________________________________________________

// Configuração de ambiente Angular (environment.prod.ts)
export const environment = {  
  apiUrl: 'https://api-meuapp.herokuapp.com',  # URL da API em produção
  production: true  # Flag indicando ambiente de produção
};

______________________________________________________________


# Configuração do Procfile (para deploy no Heroku)
web: java -jar target/nome-do-seu-jar.jar --spring.profiles.active=prod  
# Comando que o Heroku executa para iniciar a aplicação
# --spring.profiles.active=prod ativa o perfil de produção
______________________________________________________________

# Comando para criar banco de dados MySQL no Heroku
heroku addons:create cleardb:ignite -a nome-do-seu-app  
# Cria um addon do ClearDB (MySQL) para sua aplicação Heroku
______________________________________________________________

# Comando para visualizar URL de conexão com o banco
heroku config -a nome-do-seu-app | grep CLEARDB_DATABASE_URL  
# Filtra a configuração que contém a URL do banco de dados
______________________________________________________________

# Sequência de comandos para deploy no Heroku
heroku login  # Autentica no CLI do Heroku
heroku git:remote -a nome-do-seu-app  # Configura o repositório remoto
git push heroku main  # Faz push do código para o Heroku 

______________________________________________________________

# Comando para visualizar logs em tempo real
heroku logs --tail  
# Mostra os logs da aplicação (útil para debug após deploy)
______________________________________________________________

# Comando para build do Angular em produção
ng build --configuration=production  
# Gera os arquivos otimizados na pasta dist/
______________________________________________________________

# Comandos para deploy no Vercel
npm install -g vercel  # Instala o CLI da Vercel globalmente
vercel login  # Autentica na Vercel 

______________________________________________________________

# Comandos para deploy no Vercel (continuação)
cd dist/nome-do-projeto  # Entra na pasta de build
vercel --prod  # Faz deploy em produção (não é preview)

______________________________________________________________

Fluxo completo de deploy:
1. Código → Desenvolvimento da aplicação
2. Build → Compilação/otimização (Angular/Spring)
3. Push → Envio do código para plataforma
4. Hospedagem → Configuração do ambiente
5. Monitoramento → Verificação de logs e statusS
