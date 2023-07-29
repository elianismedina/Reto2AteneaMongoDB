package com.example.Reto2Web.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    public static String PENDING = "Pendiente";

    public static String APPROVED = "Aprobada";

    public static String REJECTED = "Rechazada";

    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;
    private Map<Integer,Gadget> products;
    private Map<Integer,Integer> quantities;





}
