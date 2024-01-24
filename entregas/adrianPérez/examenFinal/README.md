## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## PlantUML de Listas

@startuml

class Paciente {
    - String nombre
    - List<Encuesta> encuestas
    + Paciente(String nombre)
    + String getNombre()
    + void agregarEncuesta(Encuesta encuesta)
    + Encuesta obtenerEncuestaPorDia(int dia)
}

class Encuesta {
    - int dia
    - Map<Integer, Ingesta> ingestas
    + Encuesta(int dia)
    + int getDia()
    + void agregarIngesta(Ingesta ingesta)
    + Ingesta obtenerIngesta(int tipoIngesta)
}

class Ingesta {
    - int tipoIngesta
    - List<String> alimentos
    + Ingesta(int tipoIngesta)
    + int getTipoIngesta()
    + void agregarAlimento(String alimento)
    + void listarAlimentos()
}

class Dia {
    // Asumiendo la estructura y métodos de esta clase
    - int numeroDia
    - List<Ingesta> ingestas
    + Dia(int numeroDia)
    + void agregarIngesta(Ingesta ingesta)
    + List<Ingesta> obtenerIngestas()
}

Paciente "1" -- "*" Encuesta : contiene >
Encuesta "1" -- "*" Ingesta : contiene >
Dia "1" -- "*" Ingesta : contiene >

@enduml
