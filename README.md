# Contador de Basketball
## Moisés Ortiz Fernández 2º DAM
### Capturas de pantalla de la aplicación funcionando 

Pantalla de MainActivity
<p align="center">
<img width="368" height="814" alt="imagen" src="https://github.com/user-attachments/assets/f8ffd8c8-aaaa-4da2-9b1b-b1a05b9615f6" />
</p>
Pantalla de ScoreActivity
<p align="center">

<img width="367" height="795" alt="imagen" src="https://github.com/user-attachments/assets/ac6aa9ac-8d28-4672-bd11-99f36a65e868" />
</p>

### Implementación de Data Binding
Para mi implementación de Data Binding en ambas clases he implementado la infraestructura en ambas Activities, para poder variar los valores de los contadores y resultado de forma más eficaz tan solo llamando a la clase de Binding correspondiente a cada Activity.

### Paso de datos entre Activities
Para pasar datos desde MainActivity a ScoreActivity, he utilizado la clase Intent, introduciendo los valores de ambos contadores gracias al método putExtra() y llamando a estos datos en ScoreActivity. Al ser solamente dos variables, no ha sido necesario el uso de la interfaz Parcelable en una clase.
