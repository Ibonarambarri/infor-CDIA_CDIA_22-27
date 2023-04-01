#!/usr/bin/env python

from ingrediente import *

class Pizza:
	def __init__(self, tamanyo=0, masa=0, salsa="nada", gratinar=False, ingredientes=[]):
		if (tamanyo >= 0 and tamanyo <= 2):
			self.__tamanyo = tamanyo
		else:
			self.__tamanyo = 0
		if (masa >= 0 and masa <= 2):
			self.__masa = masa
		else:
			self.__masa = 0
		if (salsa in ["tomate", "carbonara", "barbacoa", "doble carbonara", "doble barbacoa"]):
			self.__salsa = salsa
		else:
			self.__salsa = "nada"
		self.__gratinar = gratinar
		self.__ingredientes = ingredientes[:]
		
	def __str__(self):
		stamanyo = ""
		if (self.__tamanyo == 0):
			stamanyo = "pequeña"
		elif (self.__tamanyo == 1):
			stamanyo = "mediana"
		elif (self.__tamanyo == 2):
			stamanyo = "grande"
		smasa = ""
		if (self.__masa == 0):
			smasa = "fina"
		elif (self.__masa == 1):
			smasa = "normal"
		elif (self.__masa == 2):
			smasa = "pan"
		sgratinada = ""
		if (self.__gratinar):
			sgratinada = "gratinada"
		else:
			sgratinada = "sin gratinar"
		singredientes = ""
		for i in self.__ingredientes:
			singredientes += i.get_nombre() + ", "
		return f"Pizza {stamanyo}, masa {smasa}, salsa {self.__salsa}, {sgratinada}. Ingredientes: {singredientes}"
		
	def editar(self, ingredientes):
		self.__tamanyo = int(input("Tamaño (0/1/2): "))
		self.__masa = int(input("Masa (0/1/2): "))
		self.__salsa = input("Salsa (tomate/carbonara/barbacoa/doble carbonara/doble barbacoa): ")
		opcion = input("Gratinar (s/n): ")
		if (opcion == "s"):
			self.__gratinar = True
		else:
			self.__gratinar = False
		ing = []
		for n in range(5):
			print(f"Selecciona ingrediente {n}: ")
			for i in range(len(ingredientes)):
				print(f"{i} - {ingredientes[i]}")
			opcion = int(input("¿Opción? "))
			ing.append(ingredientes[opcion])
		self.__ingredientes = ing[:]

	def getPrecio(self):
		precio = 0
		if (self.__tamanyo == 0):
			precio = 8
		elif (self.__tamanyo == 1):
			precio = 12
		elif (self.__tamanyo == 2):
			precio = 16
		for i in self.__ingredientes:
			precio += i.get_precio()
		if (self.__gratinar):
			precio += 0.5
		if (self.__salsa in ["doble carbonara", "doble barbacoa"]):
			precio += 1
		return precio

	def getPesoMasa(self):
		peso = 0
		if (self.__tamanyo == 0):
			peso = 100
		elif (self.__tamanyo == 1):
			peso = 200
		elif (self.__tamanyo == 2):
			peso = 400
		if (self.__masa == 0):
			peso *= 0.8
		elif (self.__masa == 2):
			peso *= 1.2
		return peso

	def get_tamanyo(self):
		return self.__tamanyo
	def get_masa(self):
		return self.__masa
	def get_salsa(self):
		return self.__salsa
	def get_gratinar(self):
		return self.__gratinar
	def get_ingredientes(self):
		return self.__ingredientes

	def set_tamanyo(self, tamanyo):
		if (tamanyo >= 0 and tamanyo <= 2):
			self.__tamanyo = tamanyo
	def set_masa(self, masa):
		if (masa >= 0 and masa <= 2):
			self.__masa = masa
	def set_salsa(self, salsa):
		if (salsa in ["tomate", "carbonara", "barbacoa", "doble carbonara", "doble barbacoa"]):
			self.__salsa = salsa
	def set_gratinar(self, gratinar):
		self.__gratinar = gratinar
	def set_ingredientes(self, ingredientes):
		self.__ingredientes = ingredientes[:]


