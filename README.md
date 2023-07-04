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
rmiregistry 1099
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
java ClienteCalculadora
```
