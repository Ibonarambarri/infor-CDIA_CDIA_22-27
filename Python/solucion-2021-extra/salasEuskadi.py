from cine import Cine
from pelicula import Pelicula

def cinesCartelera(cines):
	c1 = Cine("Zugaza", "Bizkaia", [Pelicula("El Padrino", 300, 1, "Paramount"), Pelicula("Soul", 600, 3, "Disney"), Pelicula("Fences", 400, 2, "Paramount"), Pelicula("Iron Man", 550, 2, "Paramount")])
	c2 = Cine("Aita Mari Antzokia", "Gipuzkoa", [Pelicula("Mujercitas", 300, 4, "Disney"), Pelicula("Pinocho", 400, 3, "Disney"), Pelicula("Iron Man", 550, 3, "Paramount")])
	c3 = Cine("Social Antzokia Basauri", "Bizkaia", [Pelicula("Greyhound", 400, 1, "Sony Pictures"), Pelicula("Corpus Christi", 600, 3)])
	cines.append(c1)
	cines.append(c2)
	cines.append(c3)
	
def ventaEntradas(cines):
	nombre = input("Nombre del cine: ")
	
	# Buscar cine por nombre...
	cine = None
	for c in cines:
		if (c.getNombre() == nombre):
			cine = c
			break
			
	# Si hemos encontrado el cine...
	if (cine != None):
		# Elegir película...
		peliculas = cine.getPeliculas()
		for i in range(len(peliculas)):
			print(f"{i+1}. {peliculas[i].getTitulo()}")
		numPelicula = int(input("Número de película: "))
		pelicula = peliculas[numPelicula-1]

		# Preparar la lista de entradas...	
		ventas = []
		numEntradas = int(input("Número de entradas: "))
		precio = float(input("Precio unitario: "))
		while (numEntradas != 0):
			ventas.append([numEntradas, precio])
			numEntradas = int(input("Número de entradas: "))
			precio = float(input("Precio unitario: "))
		
		# Actualizar recaudación
		pelicula.actualizarRecaudacion(ventas)


def recaudacionDistribuidora(cines, provincia):
	# Como no sabemos cuántas distribuidoras distintas existen, las iremos metiendo en una lista
	listaDistribuidoras = []
	listaRecaudaciones = []
	for c in cines:
		if (c.getProvincia() == provincia):
			for p in c.getPeliculas():
				# Si es una distribuidora que no tenemos en la lista, la metemos al final
				if (p.getDistribuidora() not in listaDistribuidoras):
					listaDistribuidoras.append(p.getDistribuidora())
					# También aprovechamos para añadir la recaudación de la película a la lista de recaudaciones
					# así las dos listas tienen sus elementos en el mismo orden
					listaRecaudaciones.append(p.getBalance())
				# Si es una distribuidora que ya tenemos, solo actualizamos la lista de recaudaciones
				else:
					posicion = listaDistribuidoras.index(p.getDistribuidora())
					listaRecaudaciones[posicion] += p.getBalance()

	maximo = max(listaRecaudaciones)
	# Buscamos en qué posición está el máximo en la lista de Recaudaciones
	posicion = listaRecaudaciones.index(maximo)
	# Como las listas de distribuidoras y recaudación están en el mismo orden, encontramos la distribuidora así:
	return listaDistribuidoras[posicion]


def prorrogarTaquilleras(cine):
	for p in cine.getPeliculas():
		if (p.getBalance() > 300):
			p.setSemanas(p.getSemanas() + 1)

def completarDistribuidora(cines):
	for c in cines:
		for p in c.getPeliculas():
			if (p.getDistribuidora() == "desconocida"):
				nombre = input(f"Película {p.getTitulo()}\nIntroduce el nombre de la distribuidora: ")
				p.setDistribuidora(nombre)

def asignarDescuento(cine, distribuidora):
	for p in cine.getPeliculas():
		if (p.getDistribuidora() == distribuidora):
			recaudacionSem = p.getRecaudacion() / p.getSemanas()
			if (recaudacionSem < 0):
				p.setCoste(p.getCoste()*0.75)
			elif (recaudacionSem < 100):
				p.setCoste(p.getCoste()*0.85)
			elif (recaudacionSem < 250):
				p.setCoste(p.getCoste()*0.95)

#PROGRAMA PRINCIPAL
listaCines = []
cinesCartelera(listaCines)
for c in listaCines:
	print(f"\n{c}")

print("\nVENTA DE ENTRADAS")
ventaEntradas(listaCines)
print("\nEl balance queda...")
for p in listaCines[0].getPeliculas():
	print(p.getTitulo(), ", ", p.getBalance(), " euros")

print("\nLa distribuidora más rentable en Bizkaia es: ", recaudacionDistribuidora(listaCines, "Bizkaia"))

print("\nPRORROGAR PELÍCULAS MÁS TAQUILLERAS")
prorrogarTaquilleras(listaCines[0])
for p in listaCines[0].getPeliculas():
	print(p.getTitulo(), ", ", p.getSemanas(), " semanas")

print("\nCOMPLETAR DISTRIBUIDORAS DESCONOCIDAS")
completarDistribuidora(listaCines)
for p in listaCines[2].getPeliculas():
	print(p.getTitulo(), ", ", p.getDistribuidora())


print("\nAPLICAR DESCUENTO")
for cine in listaCines:
	asignarDescuento(cine, "Paramount")
	for p in cine.getPeliculas():
		print(f"{p.getTitulo()} - {p.getCoste()}")
