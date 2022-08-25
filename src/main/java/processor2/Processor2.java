package processor2;

import lombok.AllArgsConstructor;

/**
 * anthor plan to realize process logic, Processor2, rather than IProcessor
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-25
 */
@AllArgsConstructor
public abstract class Processor2 {
    /**
     * store one context information during different processors
     */
    protected ContextHolder2 contextHolder2;

    /**
     * processor's core logic
     */
    public abstract void process();

    /**
     * this method used to debug
     */
    public String printContextHolder2() {
        return contextHolder2.toString();
    }
}
