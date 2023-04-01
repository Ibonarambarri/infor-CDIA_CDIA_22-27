class Maleta:
	def __init__(self, codigo="ZZZ", altura=0.0, anchura=0.0, largura=0.0, peso=0.0):
		self.__codigo = codigo
		if (altura >= 0):
			self.__altura = altura
		else:
			self.__altura = 0.0
		if (anchura >= 0):
			self.__anchura = anchura
		else:
			self.__anchura = 0.0
		if (largura >= 0):
			self.__largura = largura
		else:
			self.__largura = 0.0
		if (peso >= 0):
			self.__peso = peso
		else:
			self.__peso = 0.0

	def __str__(self):
		return f"Maleta {self.__codigo}, {self.__altura}x{self.__anchura}x{self.__largura} ({self.__peso} kg)"

	def get_codigo(self):
		return self.__codigo

	def get_altura(self):
		return self.__altura

	def get_anchura(self):
		return self.__anchura

	def get_largura(self):
		return self.__largura

	def get_peso(self):
		return self.__peso

	def set_codigo(self, codigo):
		self.__codigo = codigo

	def set_altura(self, altura):
		if (altura >= 0):
			self.__altura = altura

	def set_anchura(self, anchura):
		if (anchura >= 0):
			self.__anchura = anchura

	def set_largura(self, largura):
		if (largura >= 0):
			self.__largura = largura

	def set_peso(self, peso):
		if (peso >= 0):
			self.__peso = peso
