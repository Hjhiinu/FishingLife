package com.FishingLife.fishinglife.util;


import com.FishingLife.fishinglife.registry.FishingLifeItemsRegistry;
import net.minecraft.world.item.ItemStack;

public class FishingNetFunctionHandler {
    public static int netrandomNUm(int num) {

        if (num==1){
            return 1+(int) ((Math.random() * 2));
        }
        else if (num==2){
            return 2+(int) ((Math.random() * 3));
        }
        else{
            return 4 + (int)((Math.random() * 3));
        }
    }
    public static ItemStack netReturn(int num){
        if(num==1){
            return new ItemStack(FishingLifeItemsRegistry.SMALL_FISHING_NET.get());
        }
        else if(num==2){
            return new ItemStack(FishingLifeItemsRegistry.MEDIUM_FISHING_NET.get());
        }
        return new ItemStack(FishingLifeItemsRegistry.LARGE_FISHING_NET.get());
    }
    public static boolean netKeepOrNot(int num) {
        double init_value= (Math.random() * 1);

        if (num==1){
            return init_value>=0.4;
        }
        else if (num==2){
            return init_value>=0.45;
        }
        else{
            return init_value>=0.5;
        }
    }
    private static double probGerneratorForQuality(){
        return  (Math.random() * 1.1);
    }
    //0=trash, 1=common, 2=rare, 3=special, 4=extraordinary
    public static int qualityWithDifferentBait(int num){
        //double totweight=1.1;
        double cur_val=probGerneratorForQuality();
        if (num==1){
           if(0<=cur_val&&cur_val<=0.2){
               return 0;
           }
           else if(0.2<cur_val&&cur_val<=0.5){
               return 1;
           }
           else if(0.5<cur_val&&cur_val<=0.8){
               return 2;
           }
           else if(0.8<cur_val&&cur_val<=1.0){
               return 3;
           }
           else{
               return 4;
           }
        }
        else if (num==2){
            if(0<=cur_val&&cur_val<=0.1){
                return 0;
            }
            else if(0.1<cur_val&&cur_val<=0.4){
                return 1;
            }
            else if(0.4<cur_val&&cur_val<=0.7){
                return 2;
            }
            else if(0.7<cur_val&&cur_val<=0.95){
                return 3;
            }
            else{
                return 4;
            }
        }
        else if(num==3){
            if(0<=cur_val&&cur_val<=0.15){
                return 1;
            }
            else if(0.15<cur_val&&cur_val<=0.55){
                return 2;
            }
            else if(0.55<cur_val&&cur_val<=0.9){
                return 3;
            }
            else{
                return 4;
            }
        }
        else{
            if(0<=cur_val&&cur_val<=0.4){
                return 2;
            }
            else if(0.4<cur_val&&cur_val<=0.8){
                return 3;
            }
            else{
                return 4;
            }
        }

    }



}
