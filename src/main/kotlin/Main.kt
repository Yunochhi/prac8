fun main()
{
    val cableList = mutableListOf<Cabel>()
    while (true)
    {
        println("Выберите из списка что вы хотите сделать: \n 1 - Ввод новых данных \n 2 - Поиск данных \n 3 - Вывод всех данных \n 4 - Фильтрация данных по различным полям \n 5 - Удаление  \n 0 - Выход")
        when (readln().toInt())
        {
            1 ->
            {
                println("Введите вид кабеля: ")
                val type: String = readln()
                println("Введите количество жил в кабеле: ")
                val veins: Int = readln().toInt()
                println("Введите диаметр кабеля: ")
                val diameter: Double = readln().toDouble()

                cableList.add(Cabel(type, veins, diameter))
            }
            2 ->
            {
                println("По какому параметру вы хотите ощуществить поиск? \n 1 - Названию кабеля \n 2 - Количеству жил \n 3 - Диаметру кабеля")
                when (readln().toInt())
                {
                    1 -> {
                        val finderName: String = readln()
                        for (i in 0 until cableList.size)
                        {
                            if (cableList[i].name == finderName)
                            {
                                println("${cableList[i].name}, ${cableList[i].cableVeins}, ${cableList[i].diameters}")
                            }
                        }
                    }
                    2 -> {
                        val finderVeins: Int = readln().toInt()
                        for (i in 0 until cableList.size)
                        {
                            if (cableList[i].cableVeins == finderVeins)
                            {
                                println("${cableList[i].name}, ${cableList[i].cableVeins}, ${cableList[i].diameters}")
                            }
                        }
                    }
                    3 -> {
                        val finderDiameter: Double = readln().toDouble()
                        for (i in 0 until cableList.size)
                        {
                            if (cableList[i].diameters == finderDiameter)
                            {
                                println("${cableList[i].name}, ${cableList[i].cableVeins}, ${cableList[i].diameters}")
                            }
                        }
                    }
                }
            }
            3 ->
            {
                if(cableList.isNotEmpty())
                {
                    for (i in 0 until cableList.size)
                    {
                        println("${cableList[i].name}, ${cableList[i].cableVeins}, ${cableList[i].diameters}")
                    }
                }
                else println("Параметры не заданы!")
            }
            4 ->
            {
                println("Варианты фильтрации: 1 - по количеству жил, 2 - по диаметру")
                when (readln().toInt()) {
                    1 -> {
                        println("Выберите вариант сортировки: 1 - всё что больше, 2 - всё что меньше")
                        val filterType = readln().toInt()
                        println("Введите значение от которого провести сортировку: ")
                        val filterCount = readln().toInt()
                        when (filterType)
                        {
                            1 -> {
                                val filterList = cableList.filter { it.cableVeins > filterCount }
                                if (filterList.isNotEmpty())
                                {
                                    for (i in filterList.indices)
                                        println("${cableList[i].name}, ${cableList[i].cableVeins}, ${cableList[i].diameters}")
                                }
                                else println("Параметры отсутствуют!")
                            }
                            2 -> {
                                val filterList = cableList.filter { it.cableVeins < filterCount }
                                if (filterList.isNotEmpty())
                                {
                                    for (i in filterList.indices)
                                        println("${cableList[i].name}, ${cableList[i].cableVeins}, ${cableList[i].diameters}")
                                }
                                else println("Параметры отсутствуют!")
                            }
                        }
                    }
                    2 -> {
                        println("Выберите вариант сортировки: 1 - всё что больше, 2 - всё что меньше")
                        val filterType = readln().toInt()
                        println("Введите значение от которого провести сортировку: ")
                        val filterCount = readln().toDouble()
                        when (filterType) {
                            1 -> {
                                val filterList = cableList.filter { it.diameters > filterCount }
                                if (filterList.isNotEmpty())
                                {
                                    for (i in filterList.indices)
                                        println("${cableList[i].name}, ${cableList[i].cableVeins}, ${cableList[i].diameters}")
                                }
                                else println("Параметры отсутствуют!")
                            }

                            2 -> {
                                val filterList = cableList.filter { it.diameters < filterCount }
                                if (filterList.isNotEmpty())
                                {
                                    for (i in filterList.indices)
                                        println("${cableList[i].name}, ${cableList[i].cableVeins}, ${cableList[i].diameters}")
                                }
                                else println("Параметры отсутствуют!")
                            }
                        }
                    }
                }
            }
            5 ->
            {
                println("Введите индекс коллекции, которую нужно удалить: (от 0 до ...) ")
                val a:Int = readln().toInt()
                for (i in 0 until cableList.size - 1)
                {
                    cableList.removeAt(index = a)
                }
            }
            0 ->
            {
                break
            }
        }
    }
}



