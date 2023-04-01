#!/usr/bin/env python

from equipo import *
from colegio import *

def colegiosPreinscritos(colegios):
	e1 = Equipo("Equipo pre1", 2, 3, "Entrenador 1", 24, 54, 23)
	e2 = Equipo("Equipo pre2", 3, 1, "Entrenador 2", 21, 42, 13)
	e3 = Equipo("Equipo pre3", 1, 3, "Entrenador 3", 14, 59, 13)
	e4 = Equipo("Equipo pre4", 3, 1, "Entrenador 4", 46, 59, 33)
	e5 = Equipo("Equipo pre5", 3, 3, "Entrenador 5", 22, 56, 21)
	c1 = Colegio("Preinscrito 1", [e1, e2])
	c2 = Colegio("Preinscrito 2", [e3, e4])
	c3 = Colegio("Preinscrito 3", [e5])
	colegios.append(c1)
	colegios.append(c2)
	colegios.append(c3)		
	
def puntuacionesMaximas(colegios):
	mejorRobot = 0
	mejorInno = 0
	mejorValores = 0
	for colegio in colegios:
		for equipo in colegio.get_equipos():
			if (equipo.get_puntosRobot() > mejorRobot):
				mejorRobot = equipo.get_puntosRobot()
			if (equipo.get_puntosInnovacion() > mejorInno):
				mejorInno = equipo.get_puntosInnovacion()
			if (equipo.get_puntosValores() > mejorValores):
				mejorValores = equipo.get_puntosValores()
	print(f"Puntos máximos de la prueba del robot: {mejorRobot}")
	print(f"Puntos máximos de la prueba de innovación: {mejorInno}")
	print(f"Puntos máximos de la prueba de valores: {mejorValores}")
	
def anyadirColegio(colegios):
	print("Registrando nuevos colegios...")
	opcion = input("¿Quieres añadir un colegio? (s/n): ")
	while (opcion == "s"):
		colegioNuevo = Colegio()
		colegioNuevo.editar()
		colegios.append(colegioNuevo)
		opcion = input("¿Quieres añadir un colegio? (s/n): ")
	
def ratioNinyas(colegios):
	totalParticipantes = 0
	totalNinyas = 0
	for c in colegios:
		for e in c.get_equipos():
			totalNinyas += e.get_ninyas()
			totalParticipantes += e.get_ninyas() + e.get_ninyos()
	return 100 * totalNinyas / totalParticipantes
	
def equipoGanador(colegios):
	ganador = None
	for c in colegios:
		for e in c.get_equipos():
			if (ganador == None):
				ganador = e
			elif (e.getPuntuacionTotal() > ganador.getPuntuacionTotal()):
				ganador = e
	return ganador
	
def resumenParticipacion(colegios):
	print(f"Resumen del torneo:")
	print(f"{len(colegios)} colegios")
	totalEquipos = 0
	for c in colegios:
		totalEquipos += len(c.get_equipos())
	print(f"{totalEquipos} equipos")
	print(f"Un {ratioNinyas(colegios)} de niñas")
	totalRobot = 0
	totalInno = 0
	totalValores = 0
	for colegio in colegios:
		for equipo in colegio.get_equipos():
			totalRobot += equipo.get_puntosRobot()
			totalInno += equipo.get_puntosInnovacion()
			totalValores += equipo.get_puntosValores()
	print(f"Puntos de la prueba del robot: {totalRobot}")
	print(f"Puntos de la prueba de innovación: {totalInno}")
	print(f"Puntos de la prueba de valores: {totalValores}")

colegios = []
print("First Lego League Euskadi.")
colegiosPreinscritos(colegios)
puntuacionesMaximas(colegios)
anyadirColegio(colegios)
ratio = ratioNinyas(colegios)
print(f"El {ratio} \% de la gente que participa son niñas")
equipo = equipoGanador(colegios)
print(f"El equipo ganador es el {equipo.get_codigo()} con {equipo.getPuntuacionTotal()} puntos")
resumenParticipacion(colegios)
