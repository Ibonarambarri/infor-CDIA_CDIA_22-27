from pelicula import Pelicula

class Cine:
	def __init__(self, nombre="Sin nombre", provincia="Bizkaia", peliculas=[]):
		self.__nombre = nombre

		if (provincia in ["Bizkaia", "Gipuzkoa", "Álava"]):
			self.__provincia = provincia
		else:
			self.__provincia = "Bizkaia"

		self.__peliculas = peliculas

	def getNombre(self):
		return self.__nombre
	def getProvincia(self):
		return self.__provincia
	def getPeliculas(self):
		return self.__peliculas

	def setNombre(self, nombre):
		self.__nombre = nombre
	def setProvincia(self, provincia):
		if (provincia in ["Bizkaia", "Gipuzkoa", "Álava"]):
			self.__provincia = provincia
	def setPeliculas(self, peliculas):
		self.__peliculas = peliculas

	def __str__(self):
		tsony = 0
		tdisney = 0
		tparamount = 0
		tdesco =0

		for p in self.__peliculas:
			if (p.getDistribuidora() == "Sony Pictures"):
				tsony += p.getBalance()
			elif (p.getDistribuidora() == "Disney"):
				tdisney += p.getBalance()
			elif (p.getDistribuidora() == "Paramount"):
				tparamount += p.getBalance()
			else:
				tdesco += p.getBalance()
		
		total = tsony + tdisney + tparamount + tdesco
		
		return f"{self.__nombre} ({self.__provincia})\nSony Pictures: {tsony} euros\nDisney: {tdisney}\nParamount: {tparamount}\n\nTotal: {total}"

