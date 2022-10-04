package 김가희가_구현한_것_PSCS.DataStructure

class Heap {
    var arr: ArrayList<Int> = arrayListOf(-1)

    fun push(num: Int) {
        //1. 배열의 마지막에 값을 추가한다.
        arr.add(num)
        //2. 들어간 값의 인덱스
        var idx = arr.lastIndex
        //3. 부모노드와 크기 비교한다.
        while (idx > 1) {
            if(arr[idx / 2] < num) {
                arr[idx / 2] = arr[idx].also { arr[idx] = arr[idx / 2] }
                idx /= 2
            } else break
        }
    }

    fun pop() {
        if(arr.size == 1) return
        else if(arr.size == 2) arr.removeAt(1)
        else {
            //1. 제일 앞에 값에 마지막 값을 넣고 마지막 값은 삭제
            arr[1] = arr.lastOrNull()!!
            arr.removeAt(arr.lastIndex)
            //2. 자식 노드와 비교하는 루트
            var idx = 1
            while (idx * 2 <= arr.lastIndex) {
                var case1 = false
                var case2 = false

                if(arr[idx] < arr[idx * 2]) {
                    arr[idx] = arr[idx * 2].also { arr[idx * 2] = arr[idx] }
                    case1 = true
                }
                if(idx * 2 + 1<= arr.size)  {
                    if(arr[idx] < arr[idx * 2 + 1]) {
                        arr[idx] = arr[idx * 2 + 1].also { arr[idx * 2 + 1] = arr[idx] }
                        case2 = true
                    }
                }

                if(case1) idx *= 2
                else if(!case1 && !case2) break
                else idx = idx * 2 + 1
            }
        }


    }

    fun print() {
        println(arr)
    }
}

fun main() {
    var a = Heap()
    a.push(3)
    a.push(4)
    a.push(1)
    a.push(2)
    a.pop()
    a.print()
}