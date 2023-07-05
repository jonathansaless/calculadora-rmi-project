# Calculadora Científica - RMI
Repositório do Projeto Final de Sistemas Distribuídos.

# Execução do Projeto
## Servidor
### Terminal 1
```
javac *.java
```
```
rmic CalculadoraImpl
```
```
rmiregistry PORTA
```
### Terminal 2
```
java ServidorCalculadora 
```

## Cliente
```
javac *.java
```
```
java ClienteCalculadora IP PORTA
```
