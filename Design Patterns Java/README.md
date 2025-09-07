# Library Management System

Sistema de gerenciamento de biblioteca que demonstra a aplicação de padrões de projeto (Design Patterns) em Java.

## 📦 Padrões de Projeto Implementados

### 1. Singleton
- **Classe**: `LibraryCatalog`
- **Propósito**: Garantir que exista apenas uma instância do catálogo da biblioteca em toda a aplicação
- **Uso**: `LibraryCatalog.getInstance()`

### 2. Factory Method
- **Interface**: `ItemFactory`
- **Implementações**: `PhysicalBookFactory`, `EBookFactory`
- **Propósito**: Centralizar a criação de objetos e permitir extensão para novos tipos de itens

### 3. Decorator
- **Classe**: `SpecialEditionDecorator`
- **Propósito**: Adicionar funcionalidades extras aos itens da biblioteca sem modificar sua estrutura base

### 4. Observer
- **Interface**: `Observer` (implícita)
- **Propósito**: Notificar usuários sobre disponibilidade de livros
- **Uso**: `registerObserver()`, `notifyObservers()`

### 5. Strategy
- **Interface**: `BorrowStrategy`
- **Implementações**: `StandardBorrow`, `PremiumBorrow`
- **Propósito**: Permitir diferentes algoritmos de empréstimo intercambiáveis

## 🚀 Como Executar

```bash
# Compilar
javac -cp . App.java

# Executar
java App

## 🏗️ Estrutura do Projeto

src/
├── App.java                 # Classe principal
├── LibraryCatalog.java      # Singleton
├── LibraryItem.java         # Interface base
├── ItemFactory.java         # Factory Method
├── PhysicalBookFactory.java # Factory concreta
├── EBookFactory.java        # Factory concreta
├── SpecialEditionDecorator.java # Decorator
├── BorrowStrategy.java      # Strategy interface
├── StandardBorrow.java      # Strategy concreta
├── PremiumBorrow.java       # Strategy concreta
└── User.java               # Observer