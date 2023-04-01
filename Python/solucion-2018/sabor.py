class Sabor:
	def __init__(self, nombre="", hidratos=0.0, proteinas=0.0, grasas=0.0):
		self.__nombre = nombre
		self.__hidratos = hidratos
		self.__proteinas = proteinas
		self.__grasas = grasas
		
	def __str__(self):
		return f"Sabor {self.__nombre} ({self.__hidratos}, {self.__proteinas}, {self.__grasas})"
		
	def get_nombre(self):
		return self.__nombre
	def get_hidratos(self):
		return self.__hidratos
	def get_proteinas(self):
		return self.__proteinas
	def get_grasas(self):
		return self.__grasas
		
	def set_nombre(self, nombre):
		self.__nombre = nombre
	def set_hidratos(self, hidratos):
		self.__hidratos = hidratos
	def set_proteinas(self, proteinas):
		self.__proteinas = proteinas
	def set_grasas(self, grasas):
		self.__grasas = grasas
