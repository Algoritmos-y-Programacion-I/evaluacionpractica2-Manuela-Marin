package model;

public class Pillar {

    private String name;
    private Project[] projects;
    private int projectCount;

    public Pillar(String name) {
        this.name = name;
        projects = new Project[50];
        projectCount = 0;
    }

    

    public String getName() {
        return name;
    }



    /**
     * Descripcion: Añade un nuevo Project al arreglo projects
     * pre: El arreglo projects debe estar inicializado
     * pos: El arreglo projects queda modificado con el nuevo Project
     * agregado
     * 
     * @param newProject Project El Project que se va a añadir
     * @return boolean true si se logra añadir el Project, false en caso
     *         contrario
     */
    public boolean registerProject(Project newProject) {

        if (projectCount < projects.length) {
            projects[projectCount] = newProject;
            projectCount++;
            return true;

        }else{

            return false;
        }
        
    }

    /**
     * Descripcion: Genera una cadena en formato lista con la información de los
     * Project registrados en el Pillar
     * pre: El arreglo projects debe estar inicializado
     * 
     */
    public String getProjectList() {

        String list = "Proyectos del pilar" +name+ "\n";
        for (int i = 0; i < projectCount; i++) {
            list += projects[i].toString() + "\n";
        }
        return list;
    }


}

