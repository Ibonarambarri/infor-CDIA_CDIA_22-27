#!/usr/bin/env python

class Equipo:
	def __init__(self, codigo="", ninyas=0, ninyos=0, entrenador="", puntosRobot=0, puntosInnovacion=0, puntosValores=0):
		self.__codigo = codigo
		if (ninyas >= 0):
			self.__ninyas = ninyas
		else:
			self.__ninyas = 0
		if (ninyos >= 0):
			self.__ninyos = ninyos
		else:
			self.__ninyos = 0
		self.__entrenador = entrenador
		if (puntosRobot >= 0):
			self.__puntosRobot = puntosRobot				
		else: 
			self.__puntosRobot = 0
		if (puntosInnovacion >= 0):
			self.__puntosInnovacion = puntosInnovacion
		else: 
			self.__puntosInnovacion = 0			
		if (puntosValores >= 0):
			self.__puntosValores = puntosValores				
		else: 
			self.__puntosValores = 0
			
	def get_codigo(self):
		return self.__codigo
	def get_ninyas(self):
		return self.__ninyas
	def get_ninyos(self):
		return self.__ninyos
	def get_entrenador(self):
		return self.__entrenador
	def get_puntosRobot(self):
		return self.__puntosRobot
	def get_puntosInnovacion(self):
		return self.__puntosInnovacion
	def get_puntosValores(self):
		return self.__puntosValores
		
	def set_codigo(self, codigo):
		self.__codigo = codigo
	def set_ninyas(self, ninyas):
		if (ninyas >= 0):
			self.__ninyas = ninyas
	def set_ninyos(self, ninyos):
		if (ninyos >= 0):
			self.__ninyos = ninyos
	def set_entrenador(self, entrenador):
		self.__entrenador = entrenador
	def set_puntosRobot(self, puntosRobot):
		if (puntosRobot >= 0):
			self.__puntosRobot = puntosRobot
	def set_puntosInnovacion(self, puntosInnovacion):
		if (puntosInnovacion >= 0):
			self.__puntosInnovacion = puntosInnovacion
	def set_puntosValores(self, puntosValores):
		if (puntosValores >= 0):
			self.__puntosValores = puntosValores
			
	def getPuntuacionTotal(self):
		return self.__puntosRobot + self.__puntosInnovacion + self.__puntosValores
		
	def __str__(self):
		return f"Equipo {self.__codigo}. Puntuación: {self.getPuntuacionTotal()} puntos."

	def editar(self):
		self.__codigo = input("Código: ")
		self.__ninyas = int(input("Niñas: "))
		self.__ninyos = int(input("Niños: "))
		self.__entrenador = input("Entrenador/a: ")
		self.__puntosRobot = int(input("Robot: "))
		self.__puntosInnovacion = int(input("Innovación: "))
		self.__puntosValores = int(input("Valores: "))				

