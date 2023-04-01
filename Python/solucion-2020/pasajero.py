from maleta import *

class Pasajero:
	def __init__(self, nombre="Nadie", apellido="", talla=0, menu="normal", cabina=[], facturado=[]):
		self.__nombre = nombre
		self.__apellido = apellido
		if (talla >= 0 and talla <= 5):
			self.__talla = talla
		else:
			self.__talla = 0
		if (menu in ["normal", "vegetariano", "celiaco"]):
			self.__menu = menu
		else:
			self.__menu = "normal"
		self.__cabina = cabina[:]
		self.__facturado = facturado[:]

	def __str__(self):
		return f"{self.__nombre} {self.__apellido} ({self.getPesoTotal()} kg)"

	def getPesoTotal(self):
		total = 0
		for m in self.__cabina:
			total = total + m.get_peso()
		for m in self.__facturado:
			total = total + m.get_peso()
		return total

	def get_nombre(self):
		return self.__nombre

	def get_apellido(self):
		return self.__apellido

	def get_talla(self):
		return self.__talla

	def get_menu(self):
		return self.__menu

	def get_cabina(self):
		return self.__cabina

	def get_facturado(self):
		return self.__facturado

	def set_nombre(self, nombre):
		self.__nombre = nombre

	def set_apellido(self, apellido):
		self.__apellido = apellido

	def set_talla(self, talla):
		if (talla >= 0 and talla <= 5):
			self.__talla = talla

	def set_menu(self, menu):
		if (menu in ["normal", "vegetariano", "celiaco"]):
			self.__menu = menu

	def set_cabina(self, cabina):
		self.__cabina = cabina[:]

	def set_facturado(self, facturado):
		self.__facturado = facturado[:]
