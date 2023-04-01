class Helado:
	def __init__(self, tipo=0, tamayo=0, cobertura="nada", adornos=False, sabores=[]):
		if (tipo == 0 or tipo == 1):
			self.__tipo = tipo
		else:
			self.__tipo = 0
		if (tamayo == 0 or tamayo == 1 or tamayo == 2):
			self.__tamayo = tamayo		
		else:
			self.__tamayo = 0
		if (cobertura in ["chocolate", "fresa", "caramelo", "nata", "nada"]):
			self.__cobertura = cobertura
		else:
			self.__cobertura = "nada"
		self.__adornos = adornos		
		self.__sabores = sabores[:]
		
	def __str__(self):
		if (self.__tipo == 0):
			stipo = "cucurucho"
		else:
			stipo = "terrina"
		if (self.__tamayo == 0):
			stam = "pequeño"
		elif (self.__tamayo == 1):
			stam = "mediano"
		else:
			stam = "grande"
		if (self.__cobertura == "nada"):
			scobertura = "sin cobertura"
		else:
			scobertura = "con cobertura de " + self.__cobertura
		if (self__adornos):
			sadornos = "con adornos"
		else:
			sadornos = "sin adornos"
		ssabores = ""
		for s in self.__sabores:
			ssabores += s.get_nombre() + ", "
		print(f"Helado en {stipo} {stam}, {scobertura}, {sadornos}. Sabores: {ssabores}")
		
	def getPrecio(self):
		precio = 0.0
		if (self.__tamayo == 0):
			precio += len(self.__sabores) * 0.5
		elif (self.__tamayo == 1):
			precio += len(self.__sabores) * 0.75
		else:
			precio += len(self.__sabores) * 1.0
		if (self.__cobertura != "nada"):
			precio += 0.5
		if (self.__adornos):
			precio += 1.0
		return precio

	def get_tipo(self):
		return self.__tipo
	def get_tamayo(self):
		return self.__tamayo
	def get_cobertura(self):
		return self.__cobertura
	def get_adornos(self):
		return self.__adornos
	def get_sabores(self):
		return self.__sabores
		
	def set_tipo(self):
		if (tipo == 0 or tipo == 1):
			self.__tipo = tipo
	def set_tamayo(self):
		if (tamayo == 0 or tamayo == 1 or tamayo == 2):
			self.__tamayo = tamayo	
	def set_cobertura(self):
		if (cobertura in ["chocolate", "fresa", "caramelo", "nata", "nada"]):
			self.__cobertura = cobertura
	def set_adornos(self):
		self.__adornos
	def set_sabores(self):
		self.__sabores
		
	def editar(self, sabores):
		tipo = int(input("Introduce el tipo de helado (0: cucurucho, 1: terrina): "))
		while (tipo != 0 and tipo != 1):
			tipo = int(input("Introduce el tipo de helado (0: cucurucho, 1: terrina): "))
		self.__tipo = tipo
		
		tamayo = int(input("Introduce el tamaño del helado (0: pequeño, 1: mediano, 2: grande): "))
		while (tamayo != 0 and tamayo != 1 and tamayo != 2):
			tamayo = int(input("Introduce el tamaño del helado (0: pequeño, 1: mediano, 2: grande): "))
		self.__tamayo = tamayo	

		cobertura = input("Introduce la cobertura del helado (nada, chocolate, fresa, caramelo, nata): ")
		while (cobertura not in ["chocolate", "fresa", "caramelo", "nata", "nada"]):
			cobertura = input("Introduce la cobertura del helado (nada, chocolate, fresa, caramelo, nata):")
		self.__cobertura = cobertura
			
		adornos = input("¿Deseas adornos? (s/n): ")
		if (adornos == "s"):
			self.__adornos = True
		else:
			self.__adornos = False
		
		sab = []
		print("Elige los sabores del helado...")
		mas = "s"
		while (mas == "s"):
			for i in range(len(sabores)):
				s = sabores[i]
				print(f"{i} {s.get_nombre()}")
			opcion = int(input("¿Opción? "))
			sab.append(sabores[opcion])
			mas = input("¿Quieres introducir otro sabor? (s/n)")
		
		self.__sabores = sab[:]
		
