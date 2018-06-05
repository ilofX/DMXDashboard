/*
 * Copyright 2018 Filippo Stella.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.filippo.stella.dmxdashboard.Model.Utils;

/**
 *
 * @author Filippo Stella
 * @version 2.0
 */
public class ThreadGiochi extends Thread {

    public final GiochiPsichedelici giochi;

    public ThreadGiochi() {
        super("Thread Giochi");
        this.giochi = new GiochiPsichedelici();
    }
    
    @Override
    public void run() {
        
    }
    


    
}

