# 🍜 ramenGO! 🍜

<div align="center">
 <h2> Sumário</h2>
  <a href="#back">Backend</a> -
  <a href="#front">Frontend</a> - 
  <a href="#exec">Como executar o projeto</a>
</div>
<br />

RamenGO é uma aplicação fullstack desenvolvida utilizando as tecnologias:

- Backend:
  - Java 21
  - Maven
  - Spring Boot
  - Spring Data JPA
  - Spring Security
  - Banco de dados H2
  

- Frontend:
  - Javascritp
  - HTML 5
  - CSS 3
  - Vite

<h2 id="back">💻 Backend 🛠️</h2>
O Backend foi montado seguindo a arquitetura padrão de camadas, contando com recursos:

### Molho
1. [IN] O cliente faz a requisição para obter a listagem de molhos.
2. [OUT] O sistema informa a lista de molhos disponíveis.

Informações complementares:
- Na hora de fazer a requisição, o cliente deve informar, no cabeçalho de sua requisição, a chave x-api-key. Caso não informe, o acesso será negado à API.

### Proteína
1. [IN] O cliente faz a requisição para obter a listagem de proteínas.
2. [OUT] O sistema informa a lista de proteínas disponíveis.

Informações complementares:
- Na hora de fazer a requisição, o cliente deve informar, no cabeçalho de sua requisição, a chave x-api-key. Caso não informe, o acesso será negado à API.

### Pedido
1. [IN] Cliente faz a requisição (contendo em seu corpo o id do molho e o id da proteína) solicitando um pedido.
2. [OUT] Sistema informa o id do pedido, nome do ramen e imagem a ser exibida.

Informações complementares:
- Na hora de fazer a requisição, o cliente deve informar, no cabeçalho de sua requisição, a chave x-api-key. Caso não informe, o acesso será negado à API. 
- Se o corpo da requisição não contiver o id do molho ou o id da proteína, o sistema informa uma exceção personalizada.
- Na hora de processar o pedido, são buscados no banco de dados o molho e a proteína solicitados pelo cliente. Então, é feita uma requisição a uma API externa a fim de obter os dados necessários para o retorno e salvamento do pedido no banco de dados. Além de salvar a resposta do pedido, é salva também a requisição do pedido. Se feita com sucesso (ou seja, a requisição feita para obter os dados do pedido foi devidamente concluída e processada com sucesso), a requisição do pedido é salva com o status de COMPLETE. Mas, se a requisição para obter os dados do pedido não for concluída, a requisição do pedido é salva como INCOMPLETE.

### Diagrama do banco de dados:
![Diagrama de classe](/img_readme/db_diagram.png)


<h2 id="front">🎨 Frontend 📱</h2>
O frontend é construído com uma estrutura modular que facilita o desenvolvimento e a manutenção do código. Ele utiliza componentes reutilizáveis e diversas classes utilitárias em CSS para melhorar a experiência do desenvolvedor e do usuário.

### Estrutura de Arquivos
A estrutura de arquivos do frontend é organizada da seguinte forma:

```plain text
frontend/
├── assets/
├── css/
│ ├── home/
│ │ ├── cards/
│ │ │ └── cards.css
│ │ ├── header/
│ │ │ └── header.css
│ │ ├── placeorder/
│ │ │ └── placeorder.css
│ │ ├── success/
│ │ │ └── success.css
│ ├── reset/
│ │ └── reset.css
│ ├── utils/
│ │ ├── button.css
│ │ ├── colors.css
│ │ ├── container.css
│ │ ├── font.css
│ │ ├── loading.css
│ │ ├── shadow.css
│ │ ├── spacing.css
│ │ └── style.css
├── js/
│ ├── CardsList/
│ │ └── CardsList.js
│ ├── PlaceOrder/
│ │ └── PlaceOrder.js
│ ├── utils/
│ │ ├── CustomFetch.js
│ │ ├── debounce.js
│ │ ├── formatter.js
│ │ └── loadingStructure.js
│ └── main.js
├── node_modules/
├── public/
│ └── index.html
├── .gitignore
├── package-lock.json
├── package.json
```

### Funcionalidades
- **Classes Utilitárias em CSS:** Diversas classes utilitárias para estilização rápida e eficiente.
- **Debounce:** Implementação de debounce para melhorar o desempenho ao reajustar os cards em relação ao tamanho da tela.
- **Componentes Reutilizáveis:** Componentes feitos em JavaScript para facilitar o desenvolvimento de interfaces modulares.


### Desktop 🖥️
![Desktop](/img_readme/desktop.gif)

### Mobile 📱
![Desktop](/img_readme/mobile.gif)


<h2 id="exec">⚙️ Como executar o projeto ⚙️</h2>

### Backend

1. Clone o repositório:
```shell
git clone https://github.com/seu-usuario/ramenGO.git
```
2. Clone o repositório:
```shell
cd ramenGO/backend
```
3. Execute o projeto:
```shell
mvn spring-boot:run
```

### Frontend
1. Navegue até o diretório do frontend:
```shell
cd ramenGO/frontend
```
2. Instale as dependências:
```shell
npm install
```
3. Execute o projeto:
```shell
npm run dev
```
