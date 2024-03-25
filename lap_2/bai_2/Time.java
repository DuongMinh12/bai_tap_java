package bai_2;

import java.util.Scanner;

public class Time {
    private static Scanner scanner = new Scanner(System.in);
    // -----------Function---------------
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int gio, int phut, int giay) {
        this.hour = gio;
        this.minute = phut;
        this.second = giay;
    }

    // Settup

    public void Nhap() {
        System.out.print("Nhap vao gio: ");
        int gio = scanner.nextInt();
        System.out.print("Nhap vao phut: ");
        int phut = scanner.nextInt();
        System.out.print("Nhap vao giay: ");
        int giay = scanner.nextInt();
        setSecond(giay);
        // setHour(gio);
        // setMinute(phut);
        if (giay >= 60) {
            setMinute(phut);
            setHour(gio);

            tangPhut();
        } else {
            if (phut >= 60) {
                setMinute(phut);
                setHour(gio);
                tangGio();
            } else {
                setMinute(phut);
                setHour(gio);
            }
        }

    }

    public void show() {
        String time = "";
        if (this.hour >= 10 && this.minute >= 10 && this.second >= 10) {
            time = this.hour + ":" + this.minute + ":" + this.second;
            System.out.println("Thoi gian: " + time);
        } else {
            if (this.hour < 10) {
                time += "0" + this.hour;
            } else {
                time += this.hour;
            }
            time += ":";
            if (this.minute < 10) {
                time += "0" + this.minute;
            } else {
                time += this.minute;
            }
            time += ":";
            if (this.second < 10) {
                time += "0" + this.second;
            } else {
                time += this.second;
            }
            System.out.println("Thoi gian: " + time);
        }
    }

    // set

    public void setHour(int setgio) {
        if (setgio < 24 && setgio >= 0) {
            this.hour = setgio;
        } else {
            this.hour = 0;
        }
    }

    public void setMinute(int setphut) {
        if (setphut < 60 && setphut >= 0) {
            this.minute = setphut;
        } else {
            this.minute = 0;
        }
    }

    public void setSecond(int setgiay) {
        if (setgiay < 60 && setgiay >= 0) {
            this.second = setgiay;
        } else {
            this.second = 0;
        }
    }

    // get

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    // Calculate function

    public void tangPhut() {
        this.setMinute(this.minute + 1);
        if (this.minute == 0) {
            tangGio();
        }
    }

    public void tangGio() {
        this.setHour(this.hour + 1);
    }

    public void soSanh(Time time2) {

        if (this.hour == time2.hour && this.minute == time2.minute && this.second == time2.second) {
            System.out.println("Hai thoi gian tren bang nhau.");
        } else {
            if (this.hour != time2.hour) {
                if (this.hour < time2.hour) {
                    System.out.println("Thoi gian lon nhat la:");
                    time2.show();
                } else {
                    System.out.println("Thoi gian lon nhat la:");
                    show();
                }

            } else {
                if (this.minute != time2.minute) {
                    if (this.minute < time2.minute) {
                        System.out.println("Thoi gian lon nhat la:");
                        time2.show();
                    } else {
                        System.out.println("Thoi gian lon nhat la:");
                        show();
                    }

                } else {
                    if (this.second < time2.second) {
                        System.out.println("Thoi gian lon nhat la:");
                        time2.show();
                    } else {
                        System.out.println("Thoi gian lon nhat la:");
                        show();
                    }
                }
            }

        }

    }

    public void tang1Giay() {
        this.setSecond(this.second + 1);
        if (this.second == 0) {
            this.setMinute(this.minute + 1);
            if (this.minute == 0) {
                this.setHour(this.hour + 1);
                show();
            } else {
                show();
            }
        } else {
            show();
        }
    }

}
