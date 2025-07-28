package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Seat")
public class Seat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer seatId;
    
    @Column(name = "seat_area", nullable = false, length = 100)
    private String seatArea;
    
    @Column(name = "seat_floor", nullable = false)
    private Integer seatFloor;
    
    @Column(name = "is_occupied", nullable = false)
    private Boolean isOccupied = false;
    
    @Column(name = "end_time")
    private LocalDateTime endTime;
    
    // 関連エンティティ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_by")
    private Employee usedBy;
    
    // デフォルトコンストラクタ
    public Seat() {}
    
    // コンストラクタ
    public Seat(String seatArea, Integer seatFloor) {
        this.seatArea = seatArea;
        this.seatFloor = seatFloor;
        this.isOccupied = false;
    }
    
    // Getter & Setter
    public Integer getSeatId() {
        return seatId;
    }
    
    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
    
    public String getSeatArea() {
        return seatArea;
    }
    
    public void setSeatArea(String seatArea) {
        this.seatArea = seatArea;
    }
    
    public Integer getSeatFloor() {
        return seatFloor;
    }
    
    public void setSeatFloor(Integer seatFloor) {
        this.seatFloor = seatFloor;
    }
    
    public Boolean getIsOccupied() {
        return isOccupied;
    }
    
    public void setIsOccupied(Boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
    
    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    public Employee getUsedBy() {
        return usedBy;
    }
    
    public void setUsedBy(Employee usedBy) {
        this.usedBy = usedBy;
    }
    
    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", seatArea='" + seatArea + '\'' +
                ", seatFloor=" + seatFloor +
                ", isOccupied=" + isOccupied +
                ", endTime=" + endTime +
                ", usedBy=" + (usedBy != null ? usedBy.getEmployeeId() : null) +
                '}';
    }
}
