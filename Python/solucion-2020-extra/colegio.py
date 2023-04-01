#!/usr/bin/env python

from equipo import *

class Colegio: 
	def __init__(self, nombre="", equipos=[]):
		self.__nombre = nombre
		self.__equipos = equipos[:]
		
	def get_nombre(self):
		return self.__nombre
	def get_equipos(self):
		return self.__equipos
		
	def set_nombre(self, nombre):
		self.__nombre = nombre
	def set_equipos(self, equipos):
		self.__equipos = equipos[:]
		
	def __str__(self):
		return f"Colegio {self.__nombre}: {len(self.__equipos)} equipos"
		
	def getNinyasParticipantes(self):
		total = 0
		for e in self.__equipos:
			total += e.get_ninyas()
		return total
		
	def getTotalParticipantes(self):
		total = 0
		for e in self.__equipos:
			total += e.get_ninyas()
			total += e.get_ninyos()
		return total
		
	def editar(self):
		self.__nombre = input("Nombre: ")
		opcion = input("¿Quieres añadir un nuevo equipo? (s/n): ")
		while (opcion == "s"):
			print("Añadiendo nuevo equipo...")
			nuevoEquipo = Equipo()
			nuevoEquipo.editar()
			self.__equipos.append(nuevoEquipo)
			print("Equipo añadido")
			opcion = input("¿Quieres añadir un nuevo equipo? (s/n): ")
	
	
	
	
	
	
	
		
