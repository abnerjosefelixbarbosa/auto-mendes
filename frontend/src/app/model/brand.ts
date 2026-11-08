import { Model } from "./model";

export interface Brand {
    id: string | null;
    name: string | null;
    models: Model[] | null;
}
