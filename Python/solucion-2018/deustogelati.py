from sabor import *
from helado import *

def registrarVentas(helados, sabores):
	helado1 = Helado(0, 1, "nada", False, [sabores[0], sabores[1], sabores[2]])
	helado2 = Helado(1, 1, "fresa", False, [sabores[4], sabores[3], sabores[7]])
	helado3 = Helado(1, 2, "nada", True, [sabores[1], sabores[2], sabores[8]])
	helado4 = Helado(0, 0, "chocolate", False, [sabores[1], sabores[5], sabores[7]])
	helado5 = Helado(1, 2, "caramelo", False, [sabores[3], sabores[4], sabores[6]])
	helados.append(helado1)
	helados.append(helado2)
	helados.append(helado3)
	helados.append(helado4)
	helados.append(helado5)	
	opcion = input("¿Quieres introducir más helados? (s/n) ")
	while (opcion == "s"):
		nuevo = Helado()
		nuevo.editar(sabores)
		helados.append(nuevo)
		opcion = input("¿Quieres introducir más helados? (s/n) ")

def mostrarTotalesNutricionales(helados):
	hidratos = 0
	proteinas = 0
	grasas = 0
	for h in helados:
		if (h.get_tipo() == 0):
			hidratos += 17.7
			proteinas += 1.67
			grasas += 10.9
		for s in h.get_sabores():
			if (h.get_tamayo() == 0):
				multi = 0.8
			elif (h.get_tamayo() == 1):
				multi = 1.0
			else: 
				multi = 1.2
			hidratos += s.get_hidratos() * multi
			proteinas += s.get_proteinas() * multi
			grasas += s.get_grasas() * multi
	print(f"Total hidratos: {hidratos}")
	print(f"Total proteinas: {proteinas}")
	print(f"Total grasas: {grasas}")
	
def mostrarIngresoMedio(helados):
	total = 0
	for h in helados:
		total += h.getPrecio()
	media = total / len(helados)
	print(f"El precio medio de los helados ha sido {media} €")
	
helados = []

chocolate = Sabor("chocolate", 28.2, 3.8, 11)
vainilla = Sabor("vainilla", 17, 2.5, 7.9)
fresa = Sabor("fresa", 16, 1.9, 4.9)
nata = Sabor("nata", 11.9, 1.3, 4.2)
limon = Sabor("limón", 14, 1, 1)
naranja = Sabor("naranja", 17, 0.5, 0.4)
yogur = Sabor("yogur", 21.1, 2.9, 5.1)
avellana = Sabor("avellana", 29, 3.7, 14)
menta = Sabor("menta", 27, 2.1, 10)
turron = Sabor("turrón", 13.2, 1.9, 4.7)

sabores = [chocolate, vainilla, fresa, nata, limon, naranja, yogur, avellana, menta, turron]

registrarVentas(helados, sabores)

mostrarTotalesNutricionales(helados)

mostrarIngresoMedio(helados)
