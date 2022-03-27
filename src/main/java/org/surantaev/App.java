package org.surantaev;

import org.hibernate.Session;
import org.surantaev.entity.Computer;
import org.surantaev.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Computer computer = new Computer("Samsung", 1000, 250, 4);
        //save(computer);
        //System.out.println(getAllComp());
        //update(1L, "HTC", 500, 250, 4);
        //System.out.println(getCompById(1L));
        //delete(2);
    }

    private static int save(Computer computer) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(computer);
            session.getTransaction().commit();
            System.out.println("Успешно добавлен " + computer);
            return computer.getId();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }

    public static List<Computer> getAllComp() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<Computer> computerList = session.createQuery("FROM Computer").getResultList();
            List newList = new ArrayList();
            newList.add(computerList);
            session.getTransaction().commit();
            return newList;
        }finally {
            HibernateUtil.getSessionFactory().close();
        }
    }

    public static Computer getCompById(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Computer computer = session.get(Computer.class, id);
            session.getTransaction().commit();
            return computer;
        }finally {
            HibernateUtil.getSessionFactory().close();
        }
    }

    public static void update(Long id, String monitor, int hdd, int ssd, int ozu) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Computer computer1 = session.get(Computer.class, id);
            computer1.setMonitor(monitor);
            computer1.setHdd(hdd);
            computer1.setSdd(ssd);
            computer1.setOzu(ozu);
            session.getTransaction().commit();
            System.out.println("Успешно");
        }finally {
            HibernateUtil.getSessionFactory().close();
        }
    }

    public static void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Computer comp = session.get(Computer.class, id);
        session.delete(comp);
        session.getTransaction().commit();
        session.close();
        System.out.println("Компьютер успешно удалён " + comp);
    }
}
