class Pelicula:
	def __init__(self, titulo="Sin título", coste=0, semanas=0, distribuidora="desconocida"):
		self.__titulo = titulo
		
		if (coste > 0):
			self.__coste = coste
		else:
			self.__coste = 0
		
		if (semanas > 0):
			self.__semanas = semanas
		else:
			self.__semanas = 0
		
		if (distribuidora in ["Sony Pictures", "Paramount", "Disney", "desconocida"]):
			self.__distribuidora = distribuidora
		else:
			self.__distribuidora = "desconocida"

		self.__recaudacion = 0

	def getTitulo(self):
		return self.__titulo
	def getCoste(self):
		return self.__coste
	def getSemanas(self):
		return self.__semanas
	def getDistribuidora(self):
		return self.__distribuidora
	def getRecaudacion(self):
		return self.__recaudacion

	def setTitulo(self, titulo):
		self.__titulo = titulo
	def setCoste(self, coste):
		if (coste > 0):
			self.__coste = coste
	def setSemanas(self, semanas):
		if (semanas > 0):
			self.__semanas = semanas
	def setDistribuidora(self, distribuidora):
		self.__distribuidora = distribuidora
	def setRecaudacion(self, recaudacion):
		if (recaudacion > 0):
			self.__recaudacion = recaudacion

	def __str__(self):
		return f"{self.__titulo} - {self.__distribuidora} ({self.getBalance()})"
	
	def getBalance(self):
		return self.__recaudacion - self.__coste * self.__semanas
		
	def actualizarRecaudacion(self, ventas):
		for i in ventas:
			self.__recaudacion += i[0] * i[1]
