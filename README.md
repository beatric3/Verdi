# 🌿 Verdi Mobile

O **Verdi Mobile** é um aplicativo Android desenvolvido em **Java** no **Android Studio**, criado para conectar pessoas a experiências gastronômicas e sustentáveis.  
Com ele, o usuário pode explorar receitas, encontrar restaurantes próximos, salvar favoritos e gerenciar seu perfil — tudo em uma interface moderna e intuitiva.

---

## Funcionalidades

- **Cadastro e Login**
  - Criar conta ou acessar com login existente.
  - Navegação direta para a tela de cadastro via link “Não tenho cadastro...”.

- **Home**
  - Tela inicial com atalhos para todas as funcionalidades do app.

- **Receitas**
  - Lista de receitas exibidas como **cards**.
  - Botão **"Ver mais"** para expandir informações (dados mockados inicialmente).

- **Restaurantes Próximos**
  - Uso do **FusedLocationProviderClient** para obter a localização.
  - Exibição no **Google Maps** com pins para restaurantes.

- **Favoritos**
  - Salvar e remover receitas ou restaurantes como favoritos.
  - Persistência local via **SharedPreferences** ou **Room**.

- **Perfil**
  - Exibição de nome e e-mail do usuário.
  - Opção para editar dados ou sair da conta.

---

## Tecnologias Utilizadas

- **Linguagem:** Java  
- **IDE:** Android Studio  
- **Banco de Dados Local:** Room / SharedPreferences  
- **APIs:**  
  - Google Maps API  
  - FusedLocationProviderClient (localização)  
- **Layout:** XML com Material Design Components  

---

## Como Executar o Projeto

1. **Clone este repositório**
   ```bash
   git clone https://github.com/seuusuario/verdi-mobile.git
Abra no Android Studio

Configure a API do Google Maps

Crie uma chave no Google Cloud Console

Adicione no arquivo google_maps_api.xml em res/values

Compile e rode no emulador ou dispositivo físico

