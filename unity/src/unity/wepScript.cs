using UnityEngine;
using System.Collections;

public class wepScript : MonoBehaviour {

	public GameObject hitpar;
    public int damage=30;
    public int range=100;

    void Update() {
        if(Input.GetMouseButtonDown(0)){
                fireShot();
            }
    }
    public void fireShot() {
        RaycastHit hit;
        Debug.DrawRay(transform.position,hit.point,Color.black);
        Ray ray = Camera.main.ScreenPointToRay(new Vector3(Screen.width/2,Screen.height/2,0));
        if(Physics.Raycast(ray,out hit,range)){
            GameObject par = PhotonNetwork.Instantiate(hitpar.name,hit.point,hit.transform.rotation,0);
            Destroy(par,0.2f);
            if(hit.transform.GetComponent<PhotonView>()!=null)
            { 
                hit.transform.GetComponent<PhotonView>().RPC("ApplyDamage",PhotonTargets.All,damage);
                Debug.Log("hit");
            }
        }
    }
}
