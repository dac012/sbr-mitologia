# Sistema Basado en Reglas: Mitología

Este repositorio implementa y prueba un **sistema basado en reglas (SBR)** orientado al dominio de la mitología. El sistema permite modelar y razonar sobre hechos, reglas y escenarios mitológicos.

## Características principales

- **Definición de reglas** que relacionan hechos y conceptos de la mitología.
- **Inferencia automática** para deducir nuevos conocimientos o resolver escenarios planteados.
- **Gestión de escenarios** mitológicos, permitiendo analizar distintas situaciones a partir de la base de conocimientos.
- **Base de conocimiento editable** mediante archivos de texto estructurados.

## Estructura del repositorio

- `/src`: Código fuente en Java del sistema.
- `/escenarios`: Ejemplos de escenarios mitológicos sobre los que razonar.
- `/soluciones`: Resultados o salidas generadas por el sistema.
- `Conocimiento_Inicial.txt`: Base de conocimiento inicial (hechos y relaciones mitológicas).
- `Diccionario_Hechos.txt`: Definición y descripción de hechos utilizados en el sistema.

## Ejemplo de regla mitológica

```text
R1: Si hijo_de(Zeus, Heracles) Entonces semidios(Heracles)
R2: Si monstruo(Medusa) y mirada(Medusa, mortal) Entonces peligroso(Medusa)
```

## ¿Para qué usar este proyecto?

- Como base para prácticas de sistemas inteligentes, inteligencia artificial o sistemas expertos aplicados a la mitología.
- Para experimentar con modelado de conocimiento y razonamiento automático en un dominio lúdico y educativo.
- Como ejemplo práctico de sistemas basados en reglas aplicados a contextos no convencionales.
