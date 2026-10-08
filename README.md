# UFC Fantasy

## Objetivo do aplicativo

UFC Fantasy é um aplicativo Android de fantasy game de MMA. Ele mostra a pontuação do usuário e o ranking global, lista os lutadores em destaque com categoria de peso, pontuação total e pontos da última luta, e permite abrir o perfil de cada lutador para ver o desempenho (vitórias, derrotas, KOs e estatísticas de luta). No perfil, o usuário pode marcar o lutador como selecionado.

O app tem exatamente duas telas:

1. **MainActivity**: lista de lutadores (RecyclerView).
2. **FighterDetailActivity**: perfil do lutador, aberto por Intent explícita com o extra `fighter_id`.

Todos os dados são simulados (`data/MockData.kt`). Não há API, banco de dados nem acesso à internet.

## Como rodar o projeto localmente

### Pré-requisitos

- Android Studio (versão recente, compatível com Android Gradle Plugin 8.5.2, por exemplo Koala ou superior)
- JDK 17 (já incluído no Android Studio)
- Android SDK com a plataforma **API 34** instalada
- Um emulador ou celular com Android 7.0 (API 24) ou superior

### Passos

1. Clone o repositório ou extraia o `.zip` do projeto.
2. No Android Studio, escolha **File > Open** e selecione a pasta `UFCFantasy`.
3. Aguarde o **Gradle Sync** terminar. Na primeira vez ele baixa o Gradle 8.7 e as dependências, então é preciso estar online.
4. Crie ou selecione um emulador em **Device Manager**, ou conecte um celular com depuração USB ativada.
5. Clique em **Run** (▶) com a configuração `app`.

Para compilar pelo terminal, na raiz do projeto:

```bash
./gradlew assembleDebug      # Linux/macOS
gradlew.bat assembleDebug    # Windows
```

O APK é gerado em `app/build/outputs/apk/debug/`. Se `gradlew` não existir na pasta, abra o projeto uma vez no Android Studio, que o gera automaticamente.

## Bibliotecas externas

| Biblioteca | Para que serve |
|---|---|
| `androidx.core:core-ktx` | Extensões Kotlin para as APIs do Android framework. |
| `androidx.appcompat:appcompat` | Compatibilidade de `AppCompatActivity`, temas e componentes (como o `Button`) entre versões do Android. |
| `androidx.recyclerview:recyclerview` | `RecyclerView` que exibe a lista de lutadores na tela principal. |

As versões ficam em `gradle/libs.versions.toml`. Não há bibliotecas de terceiros fora do ecossistema AndroidX. O ViewBinding faz parte do Android Gradle Plugin e é habilitado em `app/build.gradle.kts`.

## Estrutura de pastas

```
app/src/main/
├── java/com/ufcfantasy/
│   ├── ui/        MainActivity, FighterDetailActivity, Formatters
│   ├── adapter/   FighterAdapter
│   ├── model/     Fighter
│   └── data/      MockData
└── res/
    ├── layout/    activity_main, activity_fighter_detail, item_fighter
    ├── drawable/  fotos, ícones e fundos
    └── values/    strings, colors, themes
```
