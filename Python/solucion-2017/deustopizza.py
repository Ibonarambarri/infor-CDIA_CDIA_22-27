#!/usr/bin/env python

from ingrediente import *
from pizza import *

def crearPizzas(pizzas, ingredientes):
	# Versión de 0.5 puntos
	pizza1 = Pizza(1, 1, "tomate", True, [ingredientes[1], ingredientes[2], ingredientes[3]])
	pizza2 = Pizza(2, 0, "carbonara", False, [ingredientes[4], ingredientes[3], ingredientes[11]])
	pizza3 = Pizza(0, 1, "nada", True, [ingredientes[2], ingredientes[7], ingredientes[7]])
	pizza4 = Pizza(1, 0, "nada", False, [ingredientes[4], ingredientes[5], ingredientes[8]])
	pizza5 = Pizza(2, 2, "doble carbonara", True, [ingredientes[7], ingredientes[1], ingredientes[6]])
	pizzas.append(pizza1)
	pizzas.append(pizza2)
	pizzas.append(pizza3)
	pizzas.append(pizza4)
	pizzas.append(pizza5)
	
	# Versión de 3.5 puntos
	opcion = "s"
	while (opcion == "s"):
		print("Introduce nueva pizza: ")
		nueva = Pizza()
		nueva.editar(ingredientes)
		pizzas.append(nueva)
		opcion = input("Pizza almacenada correctamente. ¿Quieres introducir otra? (s/n)? ")
	
def mostrarIngresos(pizzas, ingredientes):
	total = 0
	for p in pizzas:
		total += p.getPrecio()
	print(f"Ingresos totales: {total} €")
	
def mostrarMaximoIngreso(pizzas):
	mayor = pizzas[0]
	for p in pizzas:
		if (p.getPrecio() > mayor.getPrecio()):
			mayor = p
	print("Máximo ingreso: ")
	print(mayor)
	print(f"Ingreso: {mayor.getPrecio()}")

ingredientes = [
	Ingrediente("Aceitunas", 1.5, 50),
	Ingrediente("Anchoas", 2, 30),
	Ingrediente("Atún", 2, 25),
	Ingrediente("Bacon", 2, 35),
	Ingrediente("Calabacín", 1.5, 60),
	Ingrediente("Cebolla", 1, 30),
	Ingrediente("Champiñón", 1, 40),
	Ingrediente("Pepperoni", 2, 30),
	Ingrediente("Pimiento rojo", 1, 40),
	Ingrediente("Pimiento verde", 1, 50),
	Ingrediente("Piña", 1, 60),
	Ingrediente("Pollo", 2, 40),
	Ingrediente("Rúcula", 1, 30),
	Ingrediente("Salchicha", 1.5, 50),
	Ingrediente("Jamón cocido", 2, 50),
	Ingrediente("Jamón serrano", 2.5, 50)
	]
	
pizzas = []

crearPizzas(pizzas, ingredientes)
mostrarIngresos(pizzas, ingredientes)
mostrarMaximoIngreso(pizzas)
	
