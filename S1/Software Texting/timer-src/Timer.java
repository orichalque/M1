package fr.unantes.testing.timer;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * ********************
 * Classe Java Timer TD Test + TP JUnit
 *
 * @auteur Arnaud Lanoix
 * @version 2
 ***********************
 */
public class Timer {

    /**
     * définit le numéro de sonnerie choisie entre 1 et 10
     */
    protected int ring;
    /**
     * heure selectionnée pour la sonnerie : 0 - 23
     */
    protected int hour;
    /**
     * minutes selectionnées pour la sonnerie : 0 -- 59
     */
    protected int min;
    /**
     * est-ce que le minuteur est actif, càd est-ce qu'il sonnera une fois le
     * temps hour:min atteint ?
     */
    protected boolean active;
    /**
     * est-ce que le minuteur est en train de sonner ?
     */
    protected boolean ringing;

    /**
     * Le constructeur initialise le timer avec les valeurs passées en
     * paramètres. Le timer n'est pas actif et il ne sonne pas.
     *
     * @param ring choix de sonnerie entre 1 et 10
     * @param hour choix d'heure entre 0 et 23
     * @param min choix de minutes entre 0 et 59
     * @throws TimerException un des parametres est hors-limite
     */
    public Timer(int ring, int hour, int min) throws TimerException {
        if (hour < 0) {
            throw new TimerException("bad hour: inf value");
        } else if (hour > 23) {
            throw new TimerException("bad hour: sup value");
        } else if (min < 0) {
            throw new TimerException("bad min: inf value");
        } else if (min > 59) {
            throw new TimerException("bad min: sup value");
        } else if ((ring < 1) || (ring > 10)) {
            throw new TimerException("bad ring: out of limits");
        } else {
            this.ring = ring;
            this.hour = hour;
            this.min = min;
        }
        active = false;
        ringing = false;
    }

    /**
     * cette méthode permet de choisir une nouvelle sonnerie, uniquement si le
     * timer n'est pas en train de sonner.
     *
     * @param ring choix de sonnerie entre 1 et 10
     * @throws TimerException le choix de sonnerie est impossible : timer en
     * train de sonner ou ring invalide
     */
    public void selectRing(int ring) throws TimerException {
        if (ringing) {
            throw new TimerException("timer is ringing...");
        } else {
            if ((ring < 1) || (ring > 10)) {
                throw new TimerException("bad ring: out of limits");
            }
            this.ring = ring;
        }
    }

    /**
     * cette méthode incrémente le temps avec les minutes en paramètre. Elle
     * change donc l'heure et la min fixée précédemment.
     *
     * @param addedmin min à ajouter au temps fixé précédemment
     * @throws TimerException addedmin est négatif
     */
    public void addMin(int addedmin) throws TimerException {
        int addedhour = 0;
        int newmin = 0;
        int newhour = 0;
        if (addedmin < 0) {
            throw new TimerException("bad min: inf value");
        }
        while (addedmin > 59) {
            addedhour++;
            addedmin = addedmin - 60;
        }
        newmin = this.min + addedmin;
        if (newmin > 59) {
            addedhour++;
            newmin = newmin - 60;
        }
        newhour = this.hour + addedhour;
        while (newhour > 23) {
            newhour = newhour - 24;
        }
        this.hour = newhour;
        this.min = newmin;
    }

    /**
     * Cette méthode active/désactive le timer. Si le timer est actif et qu'il
     * est l'heure de sonner, alors il sonne.
     *
     * @param active true si actif, false si inactif
     */
    protected void setActive(boolean active) {
        this.active = active;
        if (this.active) {
            Calendar calendar = new GregorianCalendar();
            if (this.hour == calendar.get(Calendar.HOUR)) {
                if (this.min == calendar.get(Calendar.MINUTE)) {
                    ringing = true;
                }
            }
        }
    }

    /**
     * @param object objet à comparer pour l'égalité
     * @return true si l'objet est égal au timer courant
     */
    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof Timer) {
            return this.ring == ((Timer) object).ring
                    && this.hour == ((Timer) object).hour
                    && this.min == ((Timer) object).min
                    && this.active == ((Timer) object).active
                    && this.ringing == ((Timer) object).ringing;
        } else {
            return false;
        }
    }

    /**
     * @return une chaine de caractères caractérisant le Timer
     */
    @Override
    public String toString() {
        String str = "";
        str += hour + ":" + min;
        if (active) {
            str += "  (active";
            if (ringing) {
                str += ":ringing";
            }
            str += ")";
        }
        return str;
    }

    public static void main(String args[]) {
        try {
            Timer timer = new Timer(3, 12, 30);
            timer.setActive(true);
            System.out.println(timer);
            timer.addMin(55);
            System.out.println(timer);
        } catch (TimerException e) {
            System.out.println(e);
        }
    }
}