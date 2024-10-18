package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];
        pillars[0] = new Pillar ("Biodiversidad");
        pillars[1] = new Pillar ("Agua");
        pillars[2] = new Pillar ("Tratamiento de Basuras");
        pillars[3] = new Pillar ("Energia");

    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,boolean status) {
        
        if (pillarType >= 0 && pillarType < pillars.length) {
            Project newProject = new Project(id, name, description, status);
            return pillars[pillarType].registerProject(newProject);
        }
        return false;
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     * Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {

        String query = "";

        if (pillarType >= 0 && pillarType < pillars.length) {
            query = pillars[pillarType].getProjectList();
        }else{
            query = "Pilar no encontrado.";
        }
        return query;

    }

}