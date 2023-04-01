#!/usr/bin/env python

class Ingrediente:
	def __init__(self, nombre="", precio=0.0, peso=0.0):
		self.__nombre = nombre
		self.__precio = precio
		self.__peso = peso

	def __str__(self):
		return f"{self.__nombre} ({self.__precio}€, {self.__peso}gr)"

	def get_nombre(self):
		return self.__nombre
	def get_precio(self):
		return self.__precio
	def get_peso(self):
		return self.__peso
		
	def set_nombre(self, nombre):
		self.__nombre = nombre
	def set_precio(self, precio):
		self.__precio = precio
	def set_peso(self, peso):
		self.__peso = peso
