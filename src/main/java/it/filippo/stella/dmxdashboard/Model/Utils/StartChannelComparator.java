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

import it.filippo.stella.dmxdashboard.Model.Luce;
import java.util.Comparator;

/**
 *
 * @author Filippo
 * @version 1.0
 */
public class StartChannelComparator implements Comparator<Luce>{

    @Override
    public int compare(Luce o1, Luce o2) {
        return Integer.compare(o1.getStart(), o2.getStart());
    }
    
}
