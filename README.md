# 📍 Ba Buscou Achou (MVP)

> **Status:** 🚧 Em Desenvolvimento (Versão Experimental/Demo)

## 📱 Sobre o Projeto
O **Ba Buscou Achou** é um aplicativo nativo Android desenvolvido em Java com o objetivo de facilitar a busca, avaliação e ranking de estabelecimentos locais. 

A proposta é criar uma "personalização social" da experiência de mapas, focando em **Rankings de Satisfação** e feedback detalhado da comunidade local.

Nesta versão MVP (Minimum Viable Product), o foco foi estruturar a arquitetura de navegação, autenticação de usuários e persistência de dados local, utilizando simulações (Mocks) para as funcionalidades de GPS que serão integradas futuramente.

---

## 🚀 Funcionalidades Atuais

* **Autenticação Segura:**
    * Login via Telefone (com máscara de formatação automática).
    * Cadastro de Usuários com validação de campos.
    * Logout seguro com limpeza de pilha de atividades.
* **Navegação:**
    * Menu inferior (`BottomNavigationView`) com 3 abas principais.
    * Navegação fluida entre fragmentos.
* **Persistência de Dados (Offline):**
    * Banco de dados **SQLite** nativo para armazenar usuários e credenciais.
    * Estrutura preparada para armazenar avaliações (Check-ins).
* **Interface (UI/UX):**
    * Uso de `ConstraintLayout` para responsividade.
    * Feedback visual ao usuário (Toasts, máscaras de input).

---

## 🛠 Tecnologias Utilizadas

* **Linguagem:** Java
* **IDE:** Android Studio
* **Banco de Dados:** SQLite (Nativo)
* **Layouts:** XML (ConstraintLayout, FrameLayout)
* **Componentes:** Fragments, BottomNavigationView, Intent Filters.

---

## 🔮 Roadmap (Próximos Passos)

Como esta é uma versão de demonstração da estrutura lógica, as seguintes funcionalidades estão planejadas para a **Versão 2.0**:

- [ ] **Integração Google Maps API:** Substituir o mapa estático (Mock) pelo mapa real interativo.
- [ ] **Google Places API:** Busca real de estabelecimentos via GPS.
- [ ] **Check-in Real:** Upload de fotos da galeria/câmera para o banco de dados.
- [ ] **Sistema de Ranking:** Algoritmo para ordenar locais baseados na média de estrelas do banco de dados.
- [ ] **Categorias:** Filtros por tipo de estabelecimento (Restaurante, Serviço, Lazer).

---

## 📸 Screenshots (Em Breve)

| Tela de Login | Menu Principal | Mapa (Mock) |
|:---:|:---:|:---:|
| *(Espaço para print)* | *(Espaço para print)* | *(Espaço para print)* |

---

## 💻 Como executar o projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/SEU_USUARIO/ba-buscou-achou.git](https://github.com/SEU_USUARIO/ba-buscou-achou.git)
    ```
2.  **Abra no Android Studio:**
    * File > Open > Selecione a pasta do projeto.
3.  **Aguarde o Gradle:**
    * Espere o Android Studio baixar as dependências e indexar os arquivos.
4.  **Execute:**
    * Conecte um dispositivo físico ou inicie um Emulador.
    * Clique no botão ▶️ (Run).

---

## 👨‍💻 Autor

Desenvolvido por **[Victor B Salles]**
*Estudante de Desenvolvimento Mobile Android*

---
