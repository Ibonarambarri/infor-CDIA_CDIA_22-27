#!/usr/bin/env python

from maleta import *
from pasajero import *

def checkinOnline(pasajeros):
	pasajero = Pasajero("Pablo", "Garaizar", 3, "normal", [], [])
	pasajeros.append(pasajero)
	pasajero = Pasajero("Pablo", "Garaizar", 3, "normal", [], [])
	pasajeros.append(pasajero)
	pasajero = Pasajero("Pablo", "Garaizar", 3, "normal", [], [])
	pasajeros.append(pasajero)
	pasajero = Pasajero("Pablo", "Garaizar", 3, "normal", [], [])
	pasajeros.append(pasajero)
	pasajero = Pasajero("Pablo", "Garaizar", 3, "normal", [], [])
	pasajeros.append(pasajero)
	pasajero = Pasajero("Pablo", "Garaizar", 3, "normal", [], [])
	pasajeros.append(pasajero)

def volumenCabina(pasajeros):
	total = 0
	for p in pasajeros:
		for m in p.get_cabina():
			total = total + m.get_altura() * m.get_anchura() * m.get_largura()
	return total

def checkinAeropuerto(pasajeros):
	maspasajeros = input("¿Hay pasajeros pendientes de facturar? (s/n)")
	while (maspasajeros == "s"):
		pasajero = Pasajero()
		volumen = volumenCabina(pasajeros)
		pasajero.editar(volumen)
		pasajeros.append(pasajero)
		maspasajeros = input("¿Hay pasajeros pendientes de facturar? (s/n)")

def candidatoOverbooking(pasajeros):
	mayor = pasajeros[0]
	for p in pasajeros:
		if (p.get_pesoTotalPasajero() > mayor.get_pesoTotalPasajero()):
			mayor = p
	return mayor
	
def resumenEmbarque(pasajeros):
	print("Resumen del embarque:")
	print(f"{len(pasajeros} pasajeros embarcados")
	normales = 0
	vegetarianos = 0
	celiacos = 0
	kilosPasajero = 0
	kilosEquipaje = 0
	for p in pasajeros:
		kilosEquipaje += p.getPesoTotal()
		kilosPasajero += p.get_peso()
		if (p.get_menu() == "normal"):
			normales += 1
		elif (p.get_menu() == "vegetariano"):
			vegetarianos += 1
		elif (p.get_menu() == "celiaco"):
			celiacos += 1
	print(f"{normales} menús normales")
	print(f"{vegetarianos} menús vegetarianos")
	print(f"{celiacos} menús celiacos")
	print(f"{kilosEquipaje} kg de equipaje")
	print(f"{kilosPasajero} kg de pasajeros")
		
pasajeros = []

print('DeustoAir: de Bilbao al cielo.')

checkinOnline(pasajeros)
checkinAeropuerto(pasajeros)
overbooking = candidatoOverbooking(pasajeros)
print(f'El mejor candidato para proponerle una compensación por overbooking es {overbooking}')
resumenEmbarque(pasajeros)
