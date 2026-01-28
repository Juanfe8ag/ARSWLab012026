### ARSW Lab 01 2026-I

## Autor: Juan Felipe Ochoa

# Parte I: Introducción a Hilos en Java
Para esta parte se definen 2 clases: CountThread y CountThreadMain. En la primera se definirá el ciclo de vida del hilo
que contara números entre determinados números A y B, por otro lado, la segunda clase será donde se definen los rangos 
y se ejecutarán los hilos. 

Al iniciar los hilos con start(), se crean los hilos y se ejecutarán al mismo tiempo dando así en la salida por consola
todos los números en desorden, solo determinado por cuál hilo estaba en memoria en ese espacio de tiempo. En cambio, si
la ejecución se hace con el método run(), este NO creará hilos, simplemente ejecutará el método de la clase, haciendo
que la salida por consola sea secuencial al llamado de estos.

# Parte II: Ejercicio Black List Search
En este ejercicio se pide una refactorización, agregando una constante como parámetro para dividir el problema en N hilos. 
Para ello se creó una clase llamada BlackListThread que define la busqueda segmentada en las listas negras